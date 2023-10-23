package org.galapagos.service;

import java.io.FileInputStream;

import org.galapagos.domain.BasketballVO;
import org.springframework.stereotype.Service;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

@Service
public class BasketballServiceImpl implements BasketballService {
	
	Classifier model;
	Instances dataSet;
	
	public BasketballServiceImpl() {
		//모델 불러오기
		try {
			String[] classLabels= { "SG", "C" };
			dataSet= WekaUtil.makeInstnaces(6, classLabels); 
			
			model = (Classifier) SerializationHelper.read(new FileInputStream("E:\\Temp\\weka\\basketballJ48_96.model"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String predict(BasketballVO value) {
		Instance data = value.toInstance();
		data.setDataset(dataSet);
		
		// 분류하기
		double result = 0;
		
		try {
			result = model.classifyInstance(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataSet.classAttribute().value((int)result);
	}

}
