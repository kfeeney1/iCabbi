public class test {
    public static void main(String[] args){
        String url = "https://reqres.in/api/users/";

        getAPI.getID(url, "2");
        postAPI.postCreateUser(url);
    }
}
