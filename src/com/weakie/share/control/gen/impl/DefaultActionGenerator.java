package com.weakie.share.control.gen.impl;

import java.util.Iterator;
import java.util.Map;

import com.weakie.share.bean.Speed;
import com.weakie.share.control.gen.AbstractActionGenerator;
import com.weakie.share.control.gen.ActionBean;
import com.weakie.share.control.gen.ActionGeneratorProducer;

/**
 * Attention: current point must be same with the begin point!
 * @author weakie E-mail:weakielin@gmail.com
 * 2014��9��9������9:31:24
 */
public class DefaultActionGenerator extends AbstractActionGenerator {

	private static String TYPE = "StraightMove";
	private static String DESCRIPT = "move point straight between two points";
	static{
		ActionGeneratorProducer.register(TYPE, DefaultActionGenerator.class.getName());
	}
	
	public DefaultActionGenerator() {}

	@Override
	public Iterator<ActionBean> iterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<ActionBean>{

		private boolean hasNext = true;
		@Override
		public boolean hasNext() {
			return this.hasNext;
		}

		@Override
		public ActionBean next() {
			this.hasNext = false;
			int sx = Math.abs((int) ((endPoint.getX()-beginPoint.getX())/totalTime));
			int sy = Math.abs((int) ((endPoint.getY()-beginPoint.getY())/totalTime));
			int sz = Math.abs((int) ((endPoint.getZ()-beginPoint.getZ())/totalTime));
			return new ActionBean(0,endPoint,new Speed(sx,sy,sz),totalTime);
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

	@Override
	public void setParameter(Map<String, Object> value) {}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public String getDescript() {
		return DESCRIPT;
	}

	@Override
	public int getSize() {
		return 1;
	}

}