public class FitApp {
    public static void main (String[] args){
        Profile test = new Profile("a","2","3");
        Profile test2 = new Profile("b","2","3");
        test.follow(test2);

        //
        //System.out.println(test.getUser().getUsername());
        System.out.println(test2.getFollowers().keySet());
        for(Object key: test2.getFollowers().keySet()){
            System.out.println(key);
        }

    }
}
