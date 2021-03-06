package min.pattern.observer;

public class Client {

	public static void main(String[] args) {

		ScoreRecord scoreRecord = new ScoreRecord();
		DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
		scoreRecord.attach(dataSheetView3);
		MinMaxView minMaxView = new MinMaxView(scoreRecord);
		scoreRecord.attach(minMaxView);
		
		//3개 목록 DataSheetView,  그리고 MinMaxView가 Observer로 설정됨.
		for(int index = 1; index <=5; index++){
			
			int score = index *10;
			System.out.println("Adding "+ score);
			scoreRecord.addScore(score);//각 점수 추가 시 최대 3개 목록, 5개 목록, 최소/최대 값을 출력함.
			
		}
		
		scoreRecord.detach(dataSheetView3);//3개 목록 DataSheetView는 이제 Observer가 아님
		StatisticsView statisticsView = new StatisticsView(scoreRecord);
		scoreRecord.attach(statisticsView);//StatisticsView가 Observer로서 설정됨.
		
		//이제 5개 목록 DataSheetView, MinMaxView, 그리고 StatisticsView가 Observer임
		for(int index = 1; index <=5; index++){
			int score = index * 10;
			System.out.println("Adding "+ score);
			scoreRecord.addScore(score);//각 점수 추가 시 최대 5개 목록, 최소/최대 값, 합/평균을 출력함.
		}
		
	}

}
