public class AccessModifier {

    public static void main(String args[]) {

    BankAccount b1 = new BankAccount();
    b1.username = "ayeshakhan";
    System.out.println(b1.username);

    // we can't access password just can change it bcoz it is private
    b1.setPassword("ahdjhds");
    }
}

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }
}
