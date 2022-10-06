package Model;

public class student {
    //field-->mapping table
    private Integer id;
    private String name;
    private Integer chi;
    private Integer eng;
    private Integer math;
    private Integer sum;

    // constructors
    public student() {
    }
    
    public student(String name, Integer chi, Integer eng, Integer math) {
        this.name = name;
        this.chi = chi;
        this.eng = eng;
        this.math = math;
        
        sum=chi+eng+math;
    }
    
    //method

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChi() {
        return chi;
    }

    public void setChi(Integer chi) {
        this.chi = chi;
    }

    public Integer getEng() {
        return eng;
    }

    public void setEng(Integer eng) {
        this.eng = eng;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getSum() {
        sum=chi+eng+math;
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
    
    
    
    
}
