package wekaex;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class WekaUtil {
	
	public static Instances makeInstnaces(String[] attrNames, String[] classLabels) {
		ArrayList<Attribute> attrList= new ArrayList<>();
		for(String name : attrNames) {
			attrList.add(new Attribute(name));
		}
		return makeInstnaces(attrList, classLabels);
	}
	
	public static Instances makeInstnaces(int length, String[] classLabels) {
		ArrayList<Attribute> attrList= new ArrayList<>();
		for(int i=0; i<length; i++) {
			attrList.add(new Attribute("attr_" + i));
		}
		return makeInstnaces(attrList, classLabels);
	}
	
	// 매개 변수: 정답을 제외한 리스트 Attribute, 정답 리스트 classLabels = {"no", "yes"}
	public static Instances makeInstnaces(ArrayList<Attribute> attrList, String[] classLabels) {
		List<String> labelList= Arrays.asList(classLabels);
		attrList.add(new Attribute("@@class@@", labelList));
		
		Instances dataSet= new Instances("dataset", attrList, 0); // dataset은 임의의 문자열
		dataSet.setClassIndex(attrList.size()-1); // 정답 인덱스 지정
		return dataSet;
	}

	public static void main(String[] args) throws Exception {
//		String[] classLabels= {"no", "yes" }; //정답 label
//		String[] attrNames= { // 순서 중요!
//				"sex", "age", "sibsp", "fare", "class3","class1","class2"
//		};
//		Instances dataSet= makeInstnaces(attrNames, classLabels); // 속성명 목록으로 생성
		
//		String[] classLabels= { "no", "yes" };
//		Instances dataSet= WekaUtil.makeInstnaces(7, classLabels); // 7은 속성 개수
		String[] classLabels= { "SG", "C" };
		Instances dataSet= WekaUtil.makeInstnaces(6, classLabels);
		
		// 모델불러오기
//		RandomForest model = (RandomForest) SerializationHelper.read(new FileInputStream("E:\\Temp\\weka\\Titanic2_RandomForest.model"));
		J48 model = (J48) SerializationHelper.read(new FileInputStream("E:\\Temp\\weka\\basketballJ48_96.model"));
		
		// 분류할데이터준비
//		double[] values = new double[] {1.0,27.0,0.0,11.1333,1.0,0.0,0.0}; // yes
//		double[] values = new double[] {0.0,2.0,3.0,21.075,1.0,0.0,0.0}; // no
		double[] values = new double[] {1.5,3.5,4.3,3.4,0.8,0.5}; // no
		Instance data1 = new DenseInstance(1, values);
		data1.setDataset(dataSet);
		
		// 분류하기
		double result = model.classifyInstance(data1);
		
		// 정답출력
		System.out.println(result);
		System.out.println(dataSet.classAttribute().value((int)result));
	}

}
