import java.util.Scanner;
public class index {

    public static void main(String[] args) {

        Scanner hp = new Scanner(System.in);
        int Ibase=0, Obase = 0;
        String Inumber = "";
        String Istring = "";
        int flage_w = 0;
        System.out.println("- - - - Enter the Your Base and your number - - - -");
        System.out.print("Original Base : ");
        Ibase = hp.nextInt();

            System.out.print("Original Number : ");
            Inumber = hp.next();

        if (Ibase != 2 && Ibase != 8 && Ibase != 10 && Ibase != 16) {
            System.out.println("INVALID!!!,Your Original Base Should Be 2 or 8 or 10 or 16");
            flage_w = 1;
        } else {
            System.out.println("- - - - Enter the Base in which you Want to convert your number - - - -");
            System.out.print("Converted Base : ");
            Obase = hp.nextInt();

            if (Obase != 2 && Obase != 8 && Obase != 10 && Obase != 16) {
                System.out.println("INVALID!!!,Your Converted Base Should Be 2 or 8 or 10 or 16");
            } else {

                if (Ibase == 2) {
                    String[] ttt = new String[2];
                    if (Inumber.contains(".")) {
                        ttt = Inumber.split("[.]");
                    } else {
                        ttt[0] = Inumber;
                        ttt[1] = "0";
                    }

                    if (ttt[0].contains("2") || ttt[0].contains("3") || ttt[0].contains("4") || ttt[0].contains("5")
                            || ttt[0].contains("6") || ttt[0].contains("7") || ttt[0].contains("8")
                            || ttt[0].contains("9") || ttt[1].contains("2") || ttt[1].contains("3")
                            || ttt[1].contains("4") || ttt[1].contains("5") || ttt[1].contains("6")
                            || ttt[1].contains("7") || ttt[1].contains("8") || ttt[1].contains("9")) {

                        System.out.println("Wrong Input !!!!,Enter valid Original Number according to Original Base");

                    } else {

                        BtoX obj = new BtoX();
                        if (Obase == 8) {
                            String Ans = obj.BtoO(Inumber);
                            System.out.println("Converted Number : " + Ans);
                        } else if (Obase == 10) {
                            String Ans = obj.BtoD(Inumber);
                            System.out.println("Converted Number : " + Ans);
                        } else if (Obase == 16) {
                            String Ans = obj.BtoH(Inumber);
                            System.out.println("Converted Number : " + Ans);
                        } else if (Obase == 2) {
                            System.out.println("Converted Number : " + Inumber);

                        }

                    }
                } else if (Ibase == 10) {
                    DtoX obj = new DtoX();
                    if (Obase == 2) {
                        String Ans = obj.DtoB(Inumber);
                        System.out.println("Converted Number : " + Ans);
                    } else if (Obase == 8) {
                        String Ans = obj.DtoO(Inumber);
                        System.out.println("Converted Number : " + Ans);
                    } else if (Obase == 16) {
                        String Ans = obj.DtoH(Inumber);
                        System.out.println("Converted Number : " + Ans);
                    } else if (Obase == 10) {
                        System.out.println("Converted Number : " + Inumber);
                    }

                } else if (Ibase == 8) {
                    String[] ttt = new String[2];
                    if (Inumber.contains(".")) {
                        ttt = Inumber.split("[.]");
                    } else {
                        ttt[0] = Inumber;
                        ttt[1] = "0";
                    }
                    if (ttt[0].contains("8") || ttt[0].contains("9") || ttt[1].contains("8") || ttt[1].contains("9")) {

                        System.out.println("Wrong Input !!!!,Enter valid Original Number according to Original Base");

                    } else {

                        OtoX obj = new OtoX();
                        if (Obase == 2) {
                            String Ans = obj.OtoB(Inumber);
                            System.out.println("Converted Number : " + Ans);
                        } else if (Obase == 10) {
                            String Ans = obj.OtoD(Inumber);
                            System.out.println("Converted Number : " + Ans);
                        } else if (Obase == 16) {
                            String Ans = obj.OtoH(Inumber);
                            System.out.println("Converted Number : " + Ans);
                        } else if (Obase == 8) {
                            System.out.println("Converted Number : " + Inumber);

                        }

                    }
                } else if (Ibase == 16) {

                    String[] ttt = new String[2];
                    if (Inumber.contains(".")) {
                        ttt = Inumber.split("[.]");
                    } else {
                        ttt[0] = Inumber;
                        ttt[1] = "0";
                    }

                    if (ttt[0].matches(".*[G-Z].*") || ttt[1].matches(".*[G-Z].*")) {

                        System.out.println("Wrong Input !!!!,Enter valid Original Number according to Original Base");

                    } else {
                        HtoX obj = new HtoX();
                        if (Obase == 2) {
                            String Ansss = obj.HtoB(Inumber);
                            System.out.println("Converted Number : " +Ansss);

                        } else if (Obase == 8) {
                            String Ans = obj.HtoO(Inumber);
                            System.out.println("Converted Number : " + Ans);
                        } else if (Obase == 10) {
                            String Ans = obj.HtoD(Inumber);
                            System.out.println("Converted Number : " + Ans);
                        } else if (Obase == 16) {
                            System.out.println("Converted Number : " + Inumber);
                        } else {
                            System.out.println("INVALID!!!,Your Converted Base Should Be 2 or 8 or 10 or 16");

                        }

                    }

                }
            }
        }

    }
}
