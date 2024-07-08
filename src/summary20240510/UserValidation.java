package summary20240510;

public class UserValidation {
    private String userData;

    public static void main(String[] args) {

        System.out.println(checkLoginAndPassword("john", "123", "123"));
        System.out.println(checkLoginAndPassword("john", "123", "1234"));
        System.out.println(checkLoginAndPassword("john", "123@", "123@"));
        System.out.println(checkLoginAndPassword("john@", "123", "123"));

    }

    public static boolean checkLoginAndPassword(String login, String password, String confirmPassword) {
        try {
            if (login.length() >= 20 || !login.matches("[a-zA-Z]+"))
                throw new WrongLoginException("Check login input");

            if (password.length() >= 20 || !password.matches("[0-9]+"))
                throw new WrongPasswordException("Check password input");

            if (!password.equals(confirmPassword))
                throw new WrongPasswordException("Password does not match the confirmPassword field");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getUserInfo(){
        return "<user>" + userData + "</user>";
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }



}

