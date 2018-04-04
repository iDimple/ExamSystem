package nju.wqy.constants;

import java.util.ArrayList;

import com.google.gson.Gson;
/**
 * 
 * @author 徐江河
 * maven建议使用：
 * <!-- Gson: Java to Json conversion -->
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.2</version>
		</dependency>
 */
public class TestMain {
public static void main(String[] args) {
	Gson gson = new Gson();
	QuestionSet qs = new QuestionSet();
	
	ArrayList<Question> ql = new ArrayList<>();
	qs.questions = ql;
	
	Question q1 = new Question();
	
	ql.add(q1);
	q1.isSingleOption = false;
	q1.score = 5;
	
	ArrayList<Option> ol1 = new ArrayList<>();
	
	q1.title = "TestQ";
	q1.options = ol1;
	ol1.add(new Option(true, "A", "TestOp1"));
	ol1.add(new Option(false,"B","TestOp2"));
	
	
	String json = gson.toJson(qs);
	System.out.println(json);
	
	QuestionSet qs2 = gson.fromJson(json, QuestionSet.class);
	System.out.println(qs2.questions.get(0).title);
}
}
