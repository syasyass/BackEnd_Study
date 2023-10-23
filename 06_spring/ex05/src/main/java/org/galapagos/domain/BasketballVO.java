package org.galapagos.domain;

import lombok.Data;
import weka.core.DenseInstance;
import weka.core.Instance;

@Data
public class BasketballVO {
	private double P3;
	private double P2;
	private double TRB;
	private double AST;
	private double STL;
	private double BLK;
	
	public Instance toInstance() {
		double[] values= { // 순서 중요!
				P3, P2, TRB, AST, STL, BLK };
		return new DenseInstance(1, values);
	}
}
