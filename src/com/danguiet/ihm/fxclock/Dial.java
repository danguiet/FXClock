package com.danguiet.ihm.fxclock;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Dial extends Group {

	private Double radius;
	private Double graduationLength;

	private Circle backCircle;
	private List<Line> graduationList;

	public Dial(Double radius) {
		super();
		this.radius = radius;
		graduationLength = radius * 0.04;

		backCircle = new Circle(radius, radius, radius);
		getChildren().add(backCircle);

		graduationList = new ArrayList<>();
		for (int i = 0; i < 60; i++) {
			Double gradAngle = i * 6.0d;
			Double localGradLength = graduationLength;

			if (i % 5 == 0) {
				localGradLength = graduationLength * 2.5d;
			}

			Double startX = getCenterX() + (radius - localGradLength) * Math.sin(Math.toRadians(gradAngle));
			Double startY = getCenterY() - (radius - localGradLength) * Math.cos(Math.toRadians(gradAngle));
			Double endX = getCenterX() + radius * Math.sin(Math.toRadians(gradAngle));
			Double endY = getCenterY() - (radius) * Math.cos(Math.toRadians(gradAngle));

			Line gradLine = new Line(startX, startY, endX, endY);
			gradLine.setStroke(Color.WHITE);
			gradLine.setStrokeWidth(localGradLength*0.15);
			graduationList.add(gradLine);
			getChildren().add(gradLine);
		}
	}

	public Double getRadius() {
		return radius;
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

}
