package com.danguiet.ihm.fxclock;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Dial extends Group {

	private Double radius;
	private Double dialWidth;
	private Double graduationLength;
	private Paint color;

	private Circle backCircle;
	private List<Line> graduationList;

	public Dial(Double radius, Paint color) {
		super();
		this.color = color;
		this.radius = radius;
		dialWidth = radius * 0.1;
		graduationLength = radius * 0.04;

		backCircle = new Circle(radius + (dialWidth / 2), radius + (dialWidth / 2), radius);
		backCircle.setFill(Color.TRANSPARENT);
		backCircle.setStroke(color);
		backCircle.setStrokeWidth(dialWidth);
		getChildren().add(backCircle);

		graduationList = new ArrayList<>();
		for (int i = 0; i < 60; i++) {
			Double gradAngle = i * 6.0d;
			Double localGradLength = graduationLength;

			if (i % 5 == 0) {
				localGradLength = graduationLength * 2.5d;
			}

			Double startX = getCenterX() + (radius - localGradLength - dialWidth) * Math.sin(Math.toRadians(gradAngle));
			Double startY = getCenterY() - (radius - localGradLength - dialWidth) * Math.cos(Math.toRadians(gradAngle));
			Double endX = getCenterX() + radius * Math.sin(Math.toRadians(gradAngle));
			Double endY = getCenterY() - (radius) * Math.cos(Math.toRadians(gradAngle));

			Line gradLine = new Line(startX, startY, endX, endY);
			gradLine.setStroke(color);
			gradLine.setStrokeWidth(localGradLength * 0.15);
			graduationList.add(gradLine);
			getChildren().add(gradLine);
		}
	}

	public Double getRadius() {
		return radius;
	}

	public Double getDialWidth() {
		return dialWidth;
	}

	public Double getCenterX() {
		return backCircle.getCenterX();
	}

	public Double getCenterY() {
		return backCircle.getCenterY();
	}

	public List<Line> getGraduationList() {
		return graduationList;
	}

	public Paint getColor() {
		return color;
	}

}
