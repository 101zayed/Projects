
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Employees")
// ?????????????????????
@XmlRootElement
public class Employees {

	@XmlElement
	protected String name;
	@XmlElement
	protected String gender;
	@XmlElement
	protected int age;
	@XmlElement
	protected int id;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void Gender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

}