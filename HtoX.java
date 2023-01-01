public class HtoX {

    String setH(String in){
        switch (in.length()){
            case 1:in="000"+in;
                return in;
            case 2:in="00"+in;
                return in;
            case 3:return "0"+in;
            case 4:return in;
        }
        return in;
    }
    int CtoI(char c) {
        switch (c) {
            case '1':
                return 1;

            case '2':
                return 2;

            case '3':
                return 3;

            case '4':
                return 4;

            case '5':
                return 5;

            case '6':
                return 6;

            case '7':
                return 7;

            case '8':
                return 8;

            case '9':
                return 9;

            case 'A':
                return 10;

            case 'B':
                return 11;

            case 'C':
                return 12;

            case 'D':
                return 13;

            case 'E':
                return 14;

            case 'F':
                return 15;

        }
        return 0;
    }


        String HtoB (String H){
            H=H.replaceFirst("^0+(?!$)","");
           // System.out.println("htob="+H);
            char[] char_p0;
            int[] int_p0;
            char[] char_p1;
            int[] int_p1;
            String B="";
            String str_b="",b_deC="";
            String[] part=new String[2];

        if (H.contains(".")){

            part=H.split("[.]");
            String deC=part[1];
            String intG=part[0];
            char_p0=intG.toCharArray();
            char_p1=deC.toCharArray();

        }else {
             char_p0 = H.toCharArray();
            char_p1=H.toCharArray();
        }
            //---------------Convertion of Integar part---------------
            int_p0 = new int[char_p0.length];

            for (int i = char_p0.length - 1; i >= 0; i--) {

                int_p0[i] = CtoI(char_p0[i]);
                DtoX objforHtoB = new DtoX();
                String wrfeh="";
                str_b =wrfeh+ setH(String.valueOf(objforHtoB.DtoB(String.valueOf(int_p0[i]))))+str_b;
//                System.out.println("str_b="+str_b);
            }
            //---------------Convertion of decimal part---------------
            if(H.contains(".")&&!part[1].equals("0")){

                int_p1 = new int[char_p1.length];

                for (int i = char_p1.length - 1; i >= 0; i--) {

                    int_p1[i] = CtoI(char_p1[i]);

                    DtoX objforHtoB = new DtoX();
                    String wrfeh="";
                    b_deC =wrfeh+setH(String.valueOf(objforHtoB.DtoB(String.valueOf(int_p1[i]))))+b_deC;
              // System.out.println("b_dec="+b_deC);
                }
                str_b=str_b+"."+b_deC;
                B=str_b;

                return B;
            }
            else {

                B=str_b;
               return B;
            }
        }


        String HtoD(String H){
            H=H.replaceFirst("^0+(?!$)","");
            char[] char_p0;
            int[] int_p0;
            char[] char_p1;
            int[] int_p1;
            double D_dec=0;
            long D=0;
            String str_d="",d_deC="";
            String[] part=new String[2];

            if (H.contains(".")){

                part=H.split("[.]");
                String deC=part[1];
                String intG=part[0];
                char_p0=intG.toCharArray();
                char_p1=deC.toCharArray();

            }else {
                char_p0 = H.toCharArray();
                char_p1=H.toCharArray();

            }
            //---------------Convertion of Integar part---------------
            int_p0 = new int[char_p0.length];
            for (int i = char_p0.length - 1; i >= 0; i--) {

                int_p0[i] = CtoI(char_p0[i]);
                D+=(long) int_p0[i]*Math.pow(16,  char_p0.length-i-1);
//                System.out.println("str_b="+str_b);
            }
            str_d=String.valueOf(D);
            //---------------Convertion of decimal part---------------
            if(H.contains(".")&&!part[1].equals("0")){

                int_p1 = new int[char_p1.length];

                for (int i = 0; i< char_p1.length; i++) {

                    int_p1[i] = CtoI(char_p1[i]);
                    D_dec+=int_p1[i]*Math.pow(16, -i-1);
                    // System.out.println("b_dec="+b_deC);
                }
                d_deC=String.valueOf(D_dec);
                String[] t_str=new String[2];
                t_str=d_deC.split("[.]");
                //System.out.println("t_str0="+t_str[0]);
                //System.out.println("t_str1="+t_str[1]);
                d_deC=t_str[1];

                return str_d+"."+d_deC;
            }
            else {
                return String.valueOf(D);
            }
        }

        String HtoO(String H){

            H=H.replaceFirst("^0+(?!$)","");

           // System.out.println("H="+H);
            String HtoO_B=HtoB(H);
          //  System.out.println("b="+HtoO_B);
            BtoX objforHtoO = new BtoX();
            String O = objforHtoO.BtoO(HtoO_B);
          //  System.out.println("o="+O);
            return O;

        }

}

//class maiin{
//    public static void main(String[] args) {
//        HtoX obj1=new HtoX();
//       String te=obj1.HtoD("1234567.45");
//        System.out.println(te);
//    }
//}

