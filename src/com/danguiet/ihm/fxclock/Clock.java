package com.danguiet.ihm.fxclock;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.util.Duration;

public class Clock extends Group {

	private Calendar initialInstant;
	
	private Double clockRadius;
	
	private Dial dial;

	private TimeHand secondHand;
	private TimeHand minuteHand;
	private TimeHand hourHand;

	public Clock(Double clockRadius) {
		super();
		this.clockRadius = clockRadius;
		initialInstant = GregorianCalendar.getInstance();

		dial = new Dial(clockRadius);

		secondHand = new TimeHand(dial, ETimeHandType.SECOND, initialInstant);
		minuteHand = new TimeHand(dial, ETimeHandType.MINUTE, initialInstant);
		hourHand = new TimeHand(dial, ETimeHandType.HOUR, initialInstant);

		getChildren().addAll(dial, secondHand, minuteHand, hourHand);

		Timeline secondTimeLine = new Timeline();
		secondTimeLine.getKeyFrames().add(new KeyFrame(Duration.seconds(60),
				new KeyValue(secondHand.getRotateTransform().angleProperty(), 360d)));
		secondTimeLine.setCycleCount(Animation.INDEFINITE);

		Timeline minuteTimeLine = new Timeline();
		minuteTimeLine.getKeyFrames().add(new KeyFrame(Duration.minutes(60),
				new KeyValue(minuteHand.getRotateTransform().angleProperty(), 360d)));
		minuteTimeLine.setCycleCount(Animation.INDEFINITE);

		Timeline hourTimeLine = new Timeline();
		hourTimeLine.getKeyFrames().add(
				new KeyFrame(Duration.hours(12), new KeyValue(hourHand.getRotateTransform().angleProperty(), 360d)));
		hourTimeLine.setCycleCount(Animation.INDEFINITE);

		secondTimeLine.play();
		minuteTimeLine.play();
		hourTimeLine.play();
	}

}
