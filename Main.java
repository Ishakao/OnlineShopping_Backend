import java.util.*;
//
// https://accounts.google.com/v3/signin/accountchooser?continue=https%3A%2F%2Fdocs.google.com%2Fforms%2Fd%2Fe%2F1FAIpQLSfWbKuSDmAUAggSY8YjMW_9j5VXKznsmnsRKSyIqw_2AE11bA%2Fviewform%3Fusp%3Dheader&dsh=S303256082%3A1774346379493958&followup=https%3A%2F%2Fdocs.google.com%2Fforms%2Fd%2Fe%2F1FAIpQLSfWbKuSDmAUAggSY8YjMW_9j5VXKznsmnsRKSyIqw_2AE11bA%2Fviewform%3Fusp%3Dheader&ltmpl=forms&osid=1&passive=1209600&service=wise&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AT1y2_V_6A1z14cYUGDuHRBT7lnASXk4IHFjyURnKFQWqhglSfhcl1U7TkpYNZebJbVtj2Jb-ajGCA

public class Main {
    public static void main(String[] args) {
        Garden a = new Garden("sas", 3);
        Garden b = new Garden("sas", 3);
        Garden c = new Garden("sas", 3);

        System.out.println(a.getId());
        System.out.println(b.getId());
        System.out.println(c.getId());
    }
}