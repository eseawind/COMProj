package com.weakie.share.control.gen;

import java.util.Map;

import com.weakie.share.bean.Point3D;
import com.weakie.share.bean.Speed;


public abstract class AbstractActionGenerator implements Iterable<ActionBean> {
	
	protected Point3D beginPoint;
	protected Point3D endPoint;
	protected long totalTime;
	protected Speed speed;
	
	public AbstractActionGenerator(){}
	
	public void initBaseParam(Point3D beginPoint,Point3D endPoint,Speed speed,long time){
		this.beginPoint = beginPoint;
		this.endPoint = endPoint;
		this.speed = speed;
		this.totalTime = time;
	}
	
	public Point3D getBeginPoint() {
		return beginPoint;
	}

	public Point3D getEndPoint() {
		return endPoint;
	}

	public Speed getSpeed(){
		return this.speed;
	}
	
	public long getTotalTime() {
		return totalTime;
	}

	public abstract int getSize();
	/**
	 * @param value
	 */
	public abstract void setParameter(Map<String,Object> value);
	
	/**
	 * @return
	 */
	public abstract String getType();
	/**
	 * @return
	 */
	public abstract String getDescript();
	
}
