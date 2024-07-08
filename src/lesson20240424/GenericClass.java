package lesson20240424;

public class GenericClass <Parameter, M> {

    private Parameter parameter;

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public GenericClass(Parameter parameter) {
        this.parameter = parameter;
    }

    public void process(String info) {
        System.out.println("Processing data with info: " + info);
        System.out.println(parameter);
        System.out.println(parameter.getClass());
    }

    public Parameter function(Parameter parameter) {
        if (parameter instanceof String) {
            String string = (String) parameter;
            string = "String data after function: <" + string + ">";
            return (Parameter) string;
        } else if (parameter instanceof Integer) {
            Integer integer = (Integer) parameter;
            integer = integer + 10;
            return (Parameter) integer;
        }
        return null;
    }

    public M methodWithM(M m) {
        return m;
    }

    public <Q> void methodWithQ (Q q){
        return;
    }
}