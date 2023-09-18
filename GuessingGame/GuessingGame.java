package GuessingGame;

public class GuessingGame {
    private UserDatabase userDatabase;

    public GuessingGame(UserDatabase userDatabase){
        this.userDatabase=userDatabase;
    }

    public void playGame(String username, String password, double betAmount, int guessedNumber){
        User user = userDatabase.getUserByUsername(username);

        if (user==null){
            user=new User(username,password);
            userDatabase.addUser(user);}
        else{
            if (!user.getPassword().equals(password)) {
                System.out.println("Incorrect password");
                return;
        }
        if (user.getCoinBalance() < betAmount) {
            System.out.println("Insufficient balance");
            return;
        }
        user.setCoinBalance(user.getCoinBalance()-betAmount);
        double newBalance;
        int lotteryNumber = (int)(Math.random()*100);

        int lotteryNumber1= lotteryNumber/10;
        int lotteryNumber2= lotteryNumber%10;

        int guessNumber1=guessedNumber/10;
        int guessNumber2=guessedNumber%10;

        System.out.println("The lottery number is "+lotteryNumber);
        System.out.flush();

//        Compares the guess with lottery number.
        if(guessedNumber==lotteryNumber){
            System.out.println("You've guessed it exactly. Congratulations");
            System.out.println("Your earnings are $"+(betAmount*10));
            System.out.flush();
            newBalance = user.getCoinBalance()+(betAmount*10);
            user.setCoinBalance(newBalance);
            System.out.println("Your new balance is "+user.getCoinBalance());
            System.out.flush();
        }
        else if ((guessNumber1==lotteryNumber2) && (guessNumber2==lotteryNumber1)){
            System.out.println("You've guessed the numbers correctly but in the wrong order.");
            System.out.println("Your earnings are $"+(betAmount*3.3));
            System.out.flush();
            newBalance = user.getCoinBalance()+(betAmount*3.3);
            user.setCoinBalance(newBalance);
            System.out.println("Your new balance is "+user.getCoinBalance());
            System.out.flush();
        }
        else if (((guessNumber1==lotteryNumber1)&&(guessNumber2!=lotteryNumber2))||
                ((guessNumber2==lotteryNumber2)&&(guessNumber1)!=(lotteryNumber1))){
            System.out.println("You've guessed a number in the correct order.");
            System.out.println("Your earnings are $"+(betAmount*2));
            System.out.flush();
            newBalance = user.getCoinBalance()+(betAmount*2);
            user.setCoinBalance(newBalance);
            System.out.println("Your new balance is "+user.getCoinBalance());
            System.out.flush();
        }
        else if ((guessNumber1==lotteryNumber2)||
                (guessNumber2==lotteryNumber1)){
            System.out.println("You've guessed a number but in the wrong order. ");
            System.out.println("Your earnings are $"+(betAmount*0.75));
            System.out.flush();
            newBalance = user.getCoinBalance()+(betAmount*0.75);
            user.setCoinBalance(newBalance);
            System.out.println("Your new balance is "+user.getCoinBalance());
            System.out.flush();
        }
        else {
            System.out.println("Your guess was wrong. Try again.");
            System.out.println("Your new balance is " + user.getCoinBalance());
            System.out.flush();
        }
        user.saveUser(username+".dat");
    }
}
}

