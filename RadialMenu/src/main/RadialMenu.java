/**
 * Copyright 2013 (C) Mr LoNee - (Laurent NICOLAS) - www.mrlonee.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class RadialMenu extends Group {


    private double itemInnerRadius = 60;
    private double itemRadius = 95;
    private double centerClosedRadius = 28;
    private double centerOpenedRadius = 40;
    private double subItemInnerRadius = 100;
    private double subItemRadius = 130;
    private String[] menus;
    private String[][] subMenus;

    private Circle center;
    final List<RadialMenuItem> items;
    final List<RadialMenuItem> subItems;
    private final Group itemsGroup = new Group();
    private final Group textsGroup = new Group();
    private final Group subItemsGroup = new Group();
    private final Group subTextsGroup = new Group();
    private Circle fakeBackground;
    private Text centerText;
    private RadialMenuItem lastShown = null;

    private final Color centerColor = Color.web("ffffff");
    private final Color itemColor = Color.web("ffffff80");
    private final Paint textColor = Color.web("000000a0");
    private Paint strokeColor = Color.web("c0c0c0");
    private double startAngle = -46.0;

    final Font textFont = Font.font(java.awt.Font.SANS_SERIF,FontWeight.NORMAL, 11);
    final Font textFontBold = Font.font(java.awt.Font.SANS_SERIF,FontWeight.BOLD, 11);
    final Font menuFont = Font.font(java.awt.Font.SANS_SERIF, FontWeight.BOLD,20);

    private double animDuration = 350;
    private double animDuration2 = 100;
    private Animation openTransition;
    private Animation openTransition2;
    public final Map<RadialMenuItem, List<Text>> itemToTexts;
    public final Map<RadialMenuItem, List<RadialMenuItem>> itemToSubItem;
    private double subMenuOffset = 1;

    public RadialMenu(final String[] itemNames,
	    final double innerRadius,
	    final double radius, final double closedRadius,
	    final double openedRadius, final String[][] subItemNames,
	    final double subInnerRadius, final double subRadius) {

	menus = itemNames;
	subMenus = subItemNames;
	itemInnerRadius = innerRadius;
	itemRadius = radius;
	subItemInnerRadius = subInnerRadius;
	subItemRadius = subRadius;
	centerClosedRadius = closedRadius;
	centerOpenedRadius = openedRadius;
	

	itemToTexts = new HashMap<RadialMenuItem, List<Text>>();
	itemToSubItem = new HashMap<RadialMenuItem, List<RadialMenuItem>>();
	items = new ArrayList<RadialMenuItem>();
	subItems = new ArrayList<RadialMenuItem>();

	
	for (int i = 0; i < menus.length ; i++) {
		final String itemTitle = menus[i];
	    
	    final RadialMenuItem item = RadialMenuItemBuilder.create()
			    .clockwise(true)
			    .startAngle(i*90.0/menus.length + startAngle)
			    .length(100.0/menus.length)
			    //.backgroundFill(itemColor)
			    //.backgroundVisible(false)
			    //.backgroundMouseOnFill(Color.RED)
			    .strokeVisible(true)
			    .strokeFill(Color.YELLOW)
			    .offset(0)
			    .innerRadius(0)
			    .radius(1)
			    .build();
	    
	    List<RadialMenuItem> subItemsTemp = new ArrayList<RadialMenuItem>();
	    
	    for (int j = 0; j < subMenus[i].length; j++){
	    	
	    	final String subItemTitle = subMenus[i][j];
		    final double subLength = 90.0  / 2.5 /(menus.length-1);
		    final RadialMenuItem subItem = RadialMenuItemBuilder.create()
			    //.backgroundFill(itemColor)
		    	.innerRadius(0)
			    .radius(1)
			    .strokeVisible(true)
			    .strokeFill(Color.YELLOW)
			    .offset(0)
			    .startAngle(i*90.0/menus.length + startAngle)
			    .length(subLength)
			    .clockwise(true)
			    .build();
		    
		    subItemsTemp.add(subItem);
		    subItems.add(subItem);
		    subItemsGroup.getChildren().add(subItem);
		    
		    final List<Text> subTexts = getTextNodes(subItemTitle);
		    subTextsGroup.getChildren().addAll(subTexts);
		    //textsGroup.getChildren().addAll(subTexts);
		    itemToTexts.put(subItem, subTexts);
		    
		    subItem.setOnMouseEntered(new EventHandler<MouseEvent>(){
		    	@Override
		    	public void handle(MouseEvent event){
		    		
		    		for (final Text charText : subTexts) {
					    charText.setFill(Color.BLACK);
					    charText.setFont(textFontBold);
					}
		    	}
		    });
		    
		    subItem.setOnMouseExited(new EventHandler<MouseEvent>(){
		    	@Override
		    	public void handle(MouseEvent event){
		    		
		    		for (final Text charText : subTexts) {
					    charText.setFill(textColor);
					    charText.setFont(textFont);
					}
		    	}
		    });
	    }
	    itemToSubItem.put(item, subItemsTemp);
	    
	    items.add(item);
	    itemsGroup.getChildren().add(item);
	    final List<Text> texts = getTextNodes(itemTitle);
	    textsGroup.getChildren().addAll(texts);
	    itemToTexts.put(item, texts);
	    
	    item.setOnMouseEntered(new EventHandler<MouseEvent>(){
	    	
	    	@Override
	    	public void handle(MouseEvent event){
	    		
	    		
	    			
	    		for (final Text charText : texts) {
				    charText.setFill(Color.BLACK);
				    charText.setFont(textFontBold);
				}
	    		
	    		if (lastShown == item)
	    			return;
	    		
	    		if (openTransition2 != null) {
					Duration startDuration = Duration.millis(animDuration);
				    
						if (openTransition2.getStatus() == Status.RUNNING) {
						    openTransition2.stop();
						    startDuration = openTransition.getCurrentTime();
						}
						openTransition2.setAutoReverse(true);
						openTransition2.setCycleCount(2);
						openTransition2.playFrom(startDuration);
				    }
				
				Animation openTransition2Temp = createOpenTransition2(item);
				openTransition2Temp.play();
				if (openTransition2 != null)
					openTransition2.play();
			    openTransition2 = openTransition2Temp;
	    	}
	    });
	    
	    item.setOnMouseExited(new EventHandler<MouseEvent>(){
	    	
	    	@Override
	    	public void handle(MouseEvent event){
	    		for (final Text charText : texts) {
				    charText.setFill(textColor);
				    charText.setFont(textFont);
				}
	    		

			    lastShown = item;
	    	}
	    });
	}

	center = CircleBuilder.create().fill(Color.YELLOW)
		.radius(centerClosedRadius).stroke(strokeColor).centerX(0)
		.centerX(0).build();
	centerText = new Text("23");
	centerText.setFont(menuFont);
	centerText.setFontSmoothingType(FontSmoothingType.LCD);

	
	center.setOnMouseEntered(new EventHandler<MouseEvent>(){
		
		@Override
		public void handle(MouseEvent event){
			lastShown = null;
			if (openTransition2 != null) {
				Duration startDuration = Duration.millis(animDuration);
			    
					if (openTransition2.getStatus() == Status.RUNNING) {
					    openTransition2.stop();
					    startDuration = openTransition.getCurrentTime();
					}
					openTransition2.setAutoReverse(true);
					openTransition2.setCycleCount(2);
					openTransition2.playFrom(startDuration);
			    }
			openTransition2 = null;
		}
	});
	
	final StackPane stack = new StackPane();
	stack.getChildren().addAll(center, centerText);
	stack.translateXProperty().bind(stack.widthProperty().divide(-2.0));
	stack.translateYProperty().bind(stack.heightProperty().divide(-2.0));

	final EventHandler<? super MouseEvent> expansionEventHandler = new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(final MouseEvent event) {
	    	
		if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
		    openTransition = createOpenTransition();
		    openTransition.play();
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
		    
		    
		    if (openTransition2 != null) {
				Duration startDuration = Duration.millis(animDuration);
				if (openTransition2.getStatus() == Status.RUNNING) {
				    openTransition2.stop();
				    startDuration = openTransition2.getCurrentTime();
				}
				openTransition2.setAutoReverse(true);
				openTransition2.setCycleCount(2);
				openTransition2.playFrom(startDuration);
			    }
		    
		    if (openTransition != null) {
				Duration startDuration = Duration.millis(animDuration);
				if (openTransition.getStatus() == Status.RUNNING) {
				    openTransition.stop();
				    startDuration = openTransition.getCurrentTime();
				}
				openTransition.setAutoReverse(true);
				openTransition.setCycleCount(2);
				openTransition.playFrom(startDuration);
			    }
		    
		    lastShown = null;
		    
		}
	    }
	};
	fakeBackground = CircleBuilder.create().fill(Color.TRANSPARENT)
		.radius(centerClosedRadius + 4).centerX(0).centerX(0).build();
	
	setOnMouseEntered(expansionEventHandler);
	setOnMouseExited(expansionEventHandler);
	
	getChildren().add(fakeBackground);
	getChildren().add(subItemsGroup);
	getChildren().add(subTextsGroup);
	getChildren().addAll(itemsGroup, textsGroup, stack);
	
	
    }

    private Animation createOpenTransition2(RadialMenuItem theItem){
		
		final ParallelTransition openTransition = new ParallelTransition();
		
		final List<KeyValue> keyValueZero = new ArrayList<KeyValue>();
		final List<KeyValue> keyValueFinal = new ArrayList<KeyValue>();
		int i =0;
		List<RadialMenuItem> subItemsTemp = itemToSubItem.get(theItem);
		for (final RadialMenuItem item : subItemsTemp) {
		    keyValueZero.add(new KeyValue(item.innerRadiusProperty(),
		    	itemInnerRadius));
		    keyValueZero.add(new KeyValue(item.radiusProperty(),
			    itemRadius));

		    keyValueFinal.add(new KeyValue(item.innerRadiusProperty(),
			    subItemInnerRadius));
		    keyValueFinal.add(new KeyValue(item.radiusProperty(), subItemRadius));
		    

		    keyValueZero.add(new KeyValue(item.startAngleProperty(),
			    item.getStartAngle()));

		    keyValueFinal.add(new KeyValue(item.startAngleProperty(),
		    		item.getStartAngle() +i*(subMenuOffset + 100.0  / 2.5 /(menus.length))));
		    i++;
		    
		    final Animation textTransition = getTextOpenTransition3(item, i);
		    openTransition.getChildren().add(textTransition);
		}
		
		
		final Animation radiusTransition = new Timeline(new KeyFrame(
				Duration.ZERO, keyValueZero.toArray(new KeyValue[0])),
				new KeyFrame(Duration.millis(animDuration2), keyValueFinal
					.toArray(new KeyValue[0])));

		openTransition.getChildren().add(radiusTransition);
		
		if (!subItemsTemp.isEmpty()){
			final Animation centerTransition = new Timeline(new KeyFrame(
					Duration.ZERO, new KeyValue(
						fakeBackground.radiusProperty(),
						fakeBackground.getRadius())), new KeyFrame(
					Duration.millis(animDuration2),
					new KeyValue(fakeBackground.radiusProperty(), subItemRadius + 4)));
			openTransition.getChildren().add(centerTransition);
		}
		return openTransition;
	}
    
    private Animation createOpenTransition() {
		final ParallelTransition openTransition = new ParallelTransition();
		final Animation centerTransition = new Timeline(new KeyFrame(
			Duration.ZERO, new KeyValue(center.radiusProperty(),
				centerClosedRadius), new KeyValue(
				fakeBackground.radiusProperty(),
				fakeBackground.getRadius())), new KeyFrame(
			Duration.millis(animDuration), new KeyValue(
				center.radiusProperty(), centerOpenedRadius),
			new KeyValue(fakeBackground.radiusProperty(), itemRadius + 4)));
		openTransition.getChildren().add(centerTransition);
	
		// Text font transition
		final DoubleProperty animValue = new SimpleDoubleProperty();
		final ChangeListener<? super Number> listener = new ChangeListener<Number>() {
	
		    @Override
		    public void changed(
			    final ObservableValue<? extends Number> obsValue,
			    final Number previousValue, final Number newValue) {
			final Font f = getTextFont(newValue.doubleValue());
	
			centerText.setFont(f);
	
		    }
	
		    Font[] fonts = new Font[] {
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.BOLD, 20),
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.BOLD, 21),
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.BOLD, 22),
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.BOLD, 23),
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.BOLD, 24) };
	
		    private Font getTextFont(final double newValue) {
			final int fontArrayIndex;
			if (newValue < 0.2) {
			    fontArrayIndex = 0;
			} else if (newValue < 0.4) {
			    fontArrayIndex = 1;
			} else if (newValue < 0.6) {
			    fontArrayIndex = 2;
			} else if (newValue < 0.8) {
			    fontArrayIndex = 3;
			} else {
			    fontArrayIndex = 4;
			}
			return fonts[fontArrayIndex];
		    }
		};
		animValue.addListener(listener);
	
		final Animation menuTextTransition = new Timeline(new KeyFrame(
			Duration.ZERO, new KeyValue(animValue, 0)), new KeyFrame(
			Duration.millis(animDuration), new KeyValue(animValue, 1.0)));
	
		openTransition.getChildren().add(menuTextTransition);
	
		final List<KeyValue> keyValueZero = new ArrayList<KeyValue>();
		final List<KeyValue> keyValueFinal = new ArrayList<KeyValue>();
		
		for (final RadialMenuItem subItem : subItems){
			keyValueZero.add(new KeyValue(subItem.innerRadiusProperty(),
			    centerClosedRadius));
		    keyValueZero.add(new KeyValue(subItem.radiusProperty(),
			    centerClosedRadius));
	
		    keyValueFinal.add(new KeyValue(subItem.innerRadiusProperty(),
			    itemInnerRadius));
		    keyValueFinal.add(new KeyValue(subItem.radiusProperty(), itemRadius));
		}
	
		for (final RadialMenuItem item : items) {
			
		    keyValueZero.add(new KeyValue(item.innerRadiusProperty(),
			    centerClosedRadius));
		    keyValueZero.add(new KeyValue(item.radiusProperty(),
			    centerClosedRadius));
	
		    keyValueFinal.add(new KeyValue(item.innerRadiusProperty(),
			    itemInnerRadius));
		    keyValueFinal.add(new KeyValue(item.radiusProperty(), itemRadius));
	
		    final Animation textTransition = getTextOpenTransition(item);
		    openTransition.getChildren().add(textTransition);
		}
		
	
		final Animation radiusTransition = new Timeline(new KeyFrame(
			Duration.ZERO, keyValueZero.toArray(new KeyValue[0])),
			new KeyFrame(Duration.millis(animDuration), keyValueFinal
				.toArray(new KeyValue[0])));
	
		openTransition.getChildren().add(radiusTransition);
	
		return openTransition;
	}
    
    
    public Animation getTextOpenTransition2(final RadialMenuItem item){
    	final ParallelTransition openTransition = new ParallelTransition();
		
		final List<KeyValue> keyValueZero = new ArrayList<KeyValue>();
		final List<KeyValue> keyValueFinal = new ArrayList<KeyValue>();
		
		
		for (final Text text : itemToTexts.get(item)) {
		    text.setFont(new Font(20));
		    
		    keyValueZero.add(new KeyValue(text.translateXProperty(),
			    	text.getTranslateX()));
			    keyValueZero.add(new KeyValue(text.translateYProperty(),
				    text.getTranslateY()));
	
			    keyValueFinal.add(new KeyValue(text.translateXProperty(),
				    text.getTranslateX()+200));
			    keyValueFinal.add(new KeyValue(text.translateYProperty(), text.getTranslateY()+200));
		    
		}
		
		
		final Animation radiusTransition = new Timeline(new KeyFrame(
				Duration.ZERO, keyValueZero.toArray(new KeyValue[0])),
				new KeyFrame(Duration.millis(animDuration), keyValueFinal
					.toArray(new KeyValue[0])));

		openTransition.getChildren().add(radiusTransition);
		
		return openTransition;
    }
    
    public Animation getTextOpenTransition3(final RadialMenuItem item, int i) {
    	final List<Text> texts = itemToTexts.get(item);
    	final double textRadius = (subItemInnerRadius + subItemRadius) / 2.0;
    	final double length = item.getLength() * 0.9;

    	final double startAngle = -item.getStartAngle() - (i)*item.getLength();
    	final double angleOffset = item.getLength() * 0.1;
    	final double angleStep = (length) / (texts.size() + 1);

    	for (final Text charText : texts) {
    	    charText.setEffect(null);
    	    charText.setVisible(true);
    	}

    	final DoubleProperty animValue = new SimpleDoubleProperty();
    	final ChangeListener<? super Number> listener = new ChangeListener<Number>() {

    	    @Override
    	    public void changed(
    		    final ObservableValue<? extends Number> obsValue,
    		    final Number previousValue, final Number newValue) {
    		final double textRotationOffset = 180;
    		final double radius = itemRadius
    			+ (textRadius - itemRadius)
    			* newValue.doubleValue();

    		double letterAngle = startAngle + angleStep + angleOffset
    			+ ((1 - newValue.doubleValue()) * textRotationOffset)-1.0;

    		final Font f = getTextFont(newValue.doubleValue());

    		for (final Text charText : texts) {
    		    charText.setRotate(0);
    		    charText.setFont(f);
    		    final Bounds bounds = charText.getBoundsInParent();
    		    final double lettertWidth = bounds.getWidth();
    		    final double lettertHeight = bounds.getHeight();

    		    final double currentX = xCenterOnCircle(letterAngle,
    			    radius, lettertWidth);
    		    final double currentY = yCenterLetterOnCircle(letterAngle,
    			    radius, lettertHeight);
    		    final double rotate = rotate(letterAngle);

    		    charText.setTranslateX(currentX);
    		    charText.setTranslateY(currentY);
    		    charText.setRotate(rotate);

    		    letterAngle += angleStep;
    		}

    	    }

    	    Font[] fonts = new Font[] {
    		    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 0),
    		    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 7),
    		    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 8),
    		    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 10),
    		    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 11) };

    	    private Font getTextFont(final double newValue) {
    		final int fontArrayIndex;
    		if (newValue < 0.8) {
    		    fontArrayIndex = 0;
    		} else if (newValue < 0.85) {
    		    fontArrayIndex = 1;
    		} else if (newValue < 0.9) {
    		    fontArrayIndex = 2;
    		} else if (newValue < 0.95) {
    		    fontArrayIndex = 3;
    		} else {
    		    fontArrayIndex = 4;
    		}
    		return fonts[fontArrayIndex];
    	    }
    	};
    	animValue.addListener(listener);

    	final Animation itemTransition = new Timeline(new KeyFrame(
    		Duration.ZERO, new KeyValue(animValue, 0)), new KeyFrame(
    		Duration.millis(animDuration2), new KeyValue(animValue, 1.0)));
    	itemTransition.setOnFinished(new EventHandler<ActionEvent>() {

    	    boolean visible = false;

    	    @Override
    	    public void handle(final ActionEvent event) {
    		for (final Text charText : texts) {
    		    charText.setEffect(new Glow());
    		    if (visible) {
    			charText.setVisible(false);
    		    }
    		}
    		visible = !visible;
    	    }

    	});
    	return itemTransition;

        }
    

	public Animation getTextOpenTransition(final RadialMenuItem item) {
		final List<Text> texts = itemToTexts.get(item);
		final double textRadius = (itemInnerRadius + itemRadius) / 2.0;
		final double length = item.getLength() * 0.9;
	
		final double startAngle = -item.getStartAngle() - item.getLength();
		final double angleOffset = item.getLength() * 0.1;
		final double angleStep = (length) / (texts.size() + 1);
	
		for (final Text charText : texts) {
		    charText.setEffect(null);
		    charText.setVisible(true);
		}
	
		final DoubleProperty animValue = new SimpleDoubleProperty();
		final ChangeListener<? super Number> listener = new ChangeListener<Number>() {
	
		    @Override
		    public void changed(
			    final ObservableValue<? extends Number> obsValue,
			    final Number previousValue, final Number newValue) {
			final double textRotationOffset = 180;
			final double radius = centerClosedRadius
				+ (textRadius - centerClosedRadius)
				* newValue.doubleValue();
	
			double letterAngle = startAngle + angleStep + angleOffset
				+ ((1 - newValue.doubleValue()) * textRotationOffset)-1.0;
	
			final Font f = getTextFont(newValue.doubleValue());
	
			for (final Text charText : texts) {
			    charText.setRotate(0);
			    charText.setFont(f);
			    final Bounds bounds = charText.getBoundsInParent();
			    final double lettertWidth = bounds.getWidth();
			    final double lettertHeight = bounds.getHeight();
	
			    final double currentX = xCenterOnCircle(letterAngle,
				    radius, lettertWidth);
			    final double currentY = yCenterLetterOnCircle(letterAngle,
				    radius, lettertHeight);
			    final double rotate = rotate(letterAngle);
	
			    charText.setTranslateX(currentX);
			    charText.setTranslateY(currentY);
			    charText.setRotate(rotate);
	
			    letterAngle += angleStep;
			}
	
		    }
	
		    Font[] fonts = new Font[] {
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 6),
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 7),
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 8),
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 10),
			    Font.font(java.awt.Font.SANS_SERIF, FontWeight.NORMAL, 11) };
	
		    private Font getTextFont(final double newValue) {
			final int fontArrayIndex;
			if (newValue < 0.2) {
			    fontArrayIndex = 0;
			} else if (newValue < 0.4) {
			    fontArrayIndex = 1;
			} else if (newValue < 0.6) {
			    fontArrayIndex = 2;
			} else if (newValue < 0.8) {
			    fontArrayIndex = 3;
			} else {
			    fontArrayIndex = 4;
			}
			return fonts[fontArrayIndex];
		    }
		};
		animValue.addListener(listener);
	
		final Animation itemTransition = new Timeline(new KeyFrame(
			Duration.ZERO, new KeyValue(animValue, 0)), new KeyFrame(
			Duration.millis(animDuration), new KeyValue(animValue, 1.0)));
		itemTransition.setOnFinished(new EventHandler<ActionEvent>() {
	
		    boolean visible = false;
	
		    @Override
		    public void handle(final ActionEvent event) {
			for (final Text charText : texts) {
			    charText.setEffect(new Glow());
			    if (visible) {
				charText.setVisible(false);
			    }
			}
			visible = !visible;
		    }
	
		});
		return itemTransition;
    }

    private List<Text> getTextNodes(final String title) {
    	final List<Text> texts = new ArrayList<Text>();

    	final Text charText = new Text(title);
	    charText.setFontSmoothingType(FontSmoothingType.LCD);
	    charText.setSmooth(true);
	    charText.setMouseTransparent(true);
	    charText.setFill(textColor);
	    charText.setBlendMode(BlendMode.COLOR_BURN);
	    charText.setFont(new Font(0));
	    texts.add(charText);

	    return texts;
    }

    private double xCenterOnCircle(final double angle, final double radius,
	    final double width) {
	
    	return radius * Math.cos(Math.toRadians(angle)) - width / 2.0;
    }

    private double yCenterLetterOnCircle(final double angle,
	    final double radius, final double height) {
	
    	return -radius * Math.sin(Math.toRadians(angle)) + height / 4.0;
    }

    private double rotate(final double angle) {
	final double rotate = 0 - angle;
		
		return rotate;
    }

}

