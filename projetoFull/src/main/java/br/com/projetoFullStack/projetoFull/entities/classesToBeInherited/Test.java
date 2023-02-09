package br.com.projetoFullStack.projetoFull.entities.classesToBeInherited;

public class Test {
	
	private String name;
	private Double fullGrade;
	
	public Test() {}

	public Test(String name, Double fullGrade) {
		super();
		this.name = name;
		this.fullGrade = fullGrade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFullGrade() {
		return fullGrade;
	}

	public void setFullGrade(Double fullGrade) {
		this.fullGrade = fullGrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullGrade == null) ? 0 : fullGrade.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (fullGrade == null) {
			if (other.fullGrade != null)
				return false;
		} else if (!fullGrade.equals(other.fullGrade))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
