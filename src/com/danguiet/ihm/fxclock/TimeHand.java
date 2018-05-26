package com.danguiet.ihm.fxclock;

import java.util.Calendar;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

public class TimeHand extends Line {

	private Calendar initialInstant;
	private Dial myDial;
	private ETimeHandType type;

	private Double length;
	private Double width;
	private Double initialAngle;
	private Paint color;

	private Rotate rotateTransform;

	public TimeHand(Dial myDial, ETimeHandType type, Calendar initialInstant) {
		super();
		this.myDial = myDial;
		this.type = type;
		this.initialInstant = initialInstant;

		color = myDial.getColor();

		switch (type) {
		case SECOND:
			length = (myDial.getRadius() - myDial.getDialWidth()) * 0.99d;
			width = length * 0.015;
			initialAngle = initialInstant.get(Calendar.SECOND) * 6.0d;
			break;
		case MINUTE:
			length = (myDial.getRadius() - myDial.getDialWidth()) * 0.95d;
			width = length * 0.04;
			initialAngle = initialInstant.get(Calendar.MINUTE) * 6.0d + initialInstant.get(Calendar.SECOND) * 0.1d;
			break;
		case HOUR:
			length = (myDial.getRadius() - myDial.getDialWidth()) * 0.75d;
			width = length * 0.07;
			initialAngle = initialInstant.get(Calendar.HOUR) * 30.0d + initialInstant.get(Calendar.MINUTE) * 0.5d;
			break;
		}

		setStartX(myDial.getCenterX());
		setStartY(myDial.getCenterY());
		setEndX(myDial.getCenterX() + length * Math.sin(Math.toRadians(initialAngle)));
		setEndY(myDial.getCenterY() - length * Math.cos(Math.toRadians(initialAngle)));

		setStroke(color);
		setStrokeWidth(width);

		
		rotateTransform = new Rotate(0, myDial.getCenterX(), myDial.getCenterY());
		getTransforms().add(rotateTransform);
		
	}

	public Rotate getRotateTransform() {
		return rotateTransform;
	}

}
