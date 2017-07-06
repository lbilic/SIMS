package main;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.paint.Paint;

public class RadialMenuItemBuilder<B extends RadialMenuItemBuilder<B>> {

    private RadialMenuItem item;

    protected RadialMenuItemBuilder() {
    	this.item = new RadialMenuItem();
    }

    public static <B extends RadialMenuItemBuilder<B>> RadialMenuItemBuilder<B> create() {
    	return new RadialMenuItemBuilder<B>();
    }

    @SuppressWarnings("unchecked")
    public B startAngle(final double startAngle) {
    	this.item.setStartAngle(startAngle);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B startAngle(final DoubleProperty startAngle) {
    	this.item.startAngle.bind(startAngle);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
  	public B length(final double length) {
    	this.item.setLength(length);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B length(final DoubleProperty length) {
    	this.item.lengthProperty().bind(length);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B backgroundFill(final Paint fill) {
    	this.item.setBackgroundFill(fill);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B backgroundFill(final ObjectProperty<Paint> fillProperty) {
    	this.item.backgroundFillProperty().bind(fillProperty);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B backgroundMouseOnFill(final Paint fill) {
    	this.item.setBackgroundMouseOnFill(fill);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B backgroundMouseOnFill(final ObjectProperty<Paint> fillProperty) {
    	this.item.backgroundMouseOnFillProperty().bind(fillProperty);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B backgroundVisible(final boolean visible) {
    	this.item.setBackgroundVisible(visible);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B backgroundVisible(final BooleanProperty visible) {
    	this.item.backgroundVisibleProperty().bind(visible);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B clockwise(final boolean clockwise) {
    	this.item.setClockwise(clockwise);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B clockwise(final BooleanProperty clockwise) {
    	this.item.clockwiseProperty().bind(clockwise);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B graphic(final Node graphic) {
    	this.item.setGraphic(graphic);
    	return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B graphic(final ObjectProperty<Node> graphic) {
		this.item.graphicProperty().bind(graphic);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B radius(final double radius) {
		this.item.setRadius(radius);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B radius(final DoubleProperty radius) {
		this.item.radiusProperty().bind(radius);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B innerRadius(final double radius) {
		this.item.setInnerRadius(radius);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B innerRadius(final DoubleProperty radius) {
		this.item.innerRadiusProperty().bind(radius);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B offset(final double offset) {
		this.item.setOffset(offset);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B offset(final DoubleProperty offset) {
		this.item.offsetProperty().bind(offset);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B strokeFill(final Paint fill) {
		this.item.setStrokeFill(fill);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B strokeFill(final ObjectProperty<Paint> fill) {
		this.item.strokeFillProperty().bind(fill);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B strokeMouseOnFill(final Paint fill) {
		this.item.setStrokeMouseOnFill(fill);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B strokeMouseOnFill(final ObjectProperty<Paint> fill) {
		this.item.strokeMouseOnFillProperty().bind(fill);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B strokeVisible(final boolean visible) {
		this.item.setStrokeVisible(visible);
		return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B strokeVisible(final BooleanProperty visible) {
		this.item.strokeVisibleProperty().bind(visible);
		return (B) this;
    }

    public RadialMenuItem build() {
    	return this.item;
    }
}
