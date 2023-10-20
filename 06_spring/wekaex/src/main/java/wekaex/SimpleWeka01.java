package wekaex;

import java.io.File;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

public class SimpleWeka01 {

	public static void main(String[] args) throws Exception {
		int numfolds = 10;
		int numfold = 0;
		int seed = 1;
		
//		Instances data = new Instances(
//						new BufferedReader(
//						new FileReader("E:/Temp/weka/titanic2_pre.arff")));
		CSVLoader csvloader = new CSVLoader();
		csvloader.setSource(new File("E:/Temp/weka/basketball_stat2.csv"));
		Instances data = csvloader.getDataSet();
		
		//데이터 분할 - 훈련 데이터, 평가 데이터
		Instances train = data.trainCV(numfolds, numfold, new Random(seed));
		Instances test = data.testCV(numfolds, numfold);
		
		// 분류기 모델 설정
//		RandomForest model = new RandomForest();
//		DecisionTable model = new DecisionTable();
		J48 model = new J48(); // SVM
		
		// 정답 속성 인덱스 설정(마지막 속성)
		train.setClassIndex(train.numAttributes()-1);
		test.setClassIndex(train.numAttributes()-1);
		
		// 평가 설정
		Evaluation eval = new Evaluation(train);
		
		eval.crossValidateModel(model, train, numfolds, new Random(seed));
		
		// 랜덤 포레스트 실행
		model.buildClassifier(train);
		
		// 가치 평가
		eval.evaluateModel(model, test);
		
		// 결과 출력
		System.out.println(model);
		System.out.println(eval.toSummaryString());
		System.out.println(eval.toMatrixString());
		
		// 실제 1개의 데이터 판정
		Instance indata = test.get(1);
		
		System.out.println(indata);
		
		// 예측(predict)
		// 매번 학습시키기 부담스러우면, WEKA 워크벤치에서 만든 model을 저장해 불러와도 됨 
		double result = model.classifyInstance(indata);
		System.out.println(result); // 원 핫 인코딩의 인덱스가 출력됨
		System.out.println(test.classAttribute().value((int)result));
		
	}
}
