/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
package lcm;

/**
 *
 * @author casper
 */
public class Plate {

    private int plate;
    private String type;
    private Object answer;
    private Object correct;
    private Object weak;
    private int result;

    public Plate() {
    }

    public Plate(int plate, String type, Object answer, Object correct, Object weak, int result) {
        this.plate = plate;
        this.type = type;
        this.answer = answer;
        this.correct = correct;
        this.weak = weak;
        this.result = result;
    }

    public int getPlate() {
        return plate;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public Object getCorrect() {
        return correct;
    }

    public void setCorrect(Object correct) {
        this.correct = correct;
    }

    public Object getWeak() {
        return weak;
    }

    public void setWeak(Object weak) {
        this.weak = weak;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
