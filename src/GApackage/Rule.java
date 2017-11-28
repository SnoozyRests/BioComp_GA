package GApackage;


public class Rule {

    //variables imported from main, display only.
    private byte[] rule = new byte[Main.ruleSize];
    private byte[] condition = new byte[Main.conditionSize];
    private byte output;

    public void generateRule(){
        for(int i = 0; i <condition.length; i++){
            condition[i] = (byte)Math.round(Math.random());
            rule[i] = condition[i];
        }
        this.output = (byte) Math.round(Math.random());
        rule[rule.length-1] = output;
    }
    
    public void inputRule(String input){
        input = input.trim();
        for(int i = 0; i<6; i++){
            if(i == 5){
                output =  Byte.parseByte(""+ input.charAt(i));               
            }else{
                condition[i] = Byte.parseByte(""+ input.charAt(i));
            }
        }
        System.arraycopy(condition, 0, rule, 0, condition.length);
        rule[rule.length-1] = output;
    }

    public String getCondition() {
        String temp = "";
        for (int k = 0; k < condition.length; k++) {
            temp += "" + condition[k];
        }
        return temp;
    }
    
    public String getRuleString() {
        String temp = "";
        for (int k = 0; k < rule.length; k++) {
            temp += "" + rule[k];
        }
        return temp;
    }

    public String getOutput() {
        return Integer.toString(output);
    }
    
    public byte[] getRule(){
        return rule;
    }   
    
    
}
