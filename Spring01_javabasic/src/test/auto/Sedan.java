package test.auto;

public class Sedan extends Car{
	public Sedan(Engine engine) {
		super(engine);
	}

	private String name;
	
	private int weight;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void showInfo() {
		System.out.println("세단의 이름은 : " + name + "세단의 무게는:" + weight);
	}

}
