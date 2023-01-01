public class OtoX {

    String setO(String in){
        switch (in.length()){
            case 1:in="00"+in;
                return in;
            case 2:in="0"+in;
                return in;
            case 3:return in;
        }
        return in;
    }
    String OtoB(String O){
      //  O=O.replaceFirst("^0+(?!$)","");
        String[] part=O.split("[.]");
        String str_b="",b_deC="";
        String B="";

        String[] temp_str= part[0].split("(?<=\\G.{" + 1 + "})");

        String[] a=new String[temp_str.length];
        for (int i= temp_str.length-1;i>=0;i--){
            a[i]=temp_str[temp_str.length-i-1];
        }
        temp_str=a;

        //---------------Convertion of Integar part---------------
        for(int qwe=0;qwe<temp_str.length;qwe++){
            DtoX objforOtoB=new DtoX();
            str_b+=setO(objforOtoB.DtoB(temp_str[qwe]));
        }

        //---------------Convertion of decimal part---------------
        if(O.contains(".")){

            temp_str= part[1].split("(?<=\\G.{" + 1 + "})");
            a=new String[temp_str.length];
            for (int i= temp_str.length-1;i>=0;i--){
                a[i]=temp_str[temp_str.length-i-1];
            }
            temp_str=a;

            for (int qwe=0;qwe<temp_str.length;qwe++){
                DtoX objforOtoB=new DtoX();
                b_deC+=setO(objforOtoB.DtoB(temp_str[qwe]));
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

    String OtoD(String O){
      //  O=O.replaceFirst("^0+(?!$)","");
        String[] part=O.split("[.]");
        String str_d="",d_deC="";
        double D=0,D_deC=0;
        double i=0;
        long rm=0;
        double deC=0,intG=Integer.parseInt(part[0]);

        //---------------Convertion of Integar part---------------

        while (intG>0){
            rm=(long) intG%10;
            intG=intG/10;
            D+= rm*Math.pow(8,i);
            i++;
        }
        i=0;
        //---------------Convertion of decimal part---------------
        if(O.contains(".")){
            deC=Integer.parseInt(part[1]);
            d_deC=part[1];

            while (deC>0){
                rm=(long) (deC%10);
                deC=(long)(deC/10);
                D_deC+=rm*Math.pow(8,-d_deC.length()+i);
                i++;
            }

            D+=D_deC;
            if (D % 1 == 0) {
                return String.valueOf((long) D);
            } else {
                return String.valueOf(D);
            }
        }
        else {

            if (D % 1 == 0) {
                return String.valueOf((long) D);
            } else {
                return String.valueOf(D);
            }
        }
    }

    String OtoH(String O){
//        O=O.replaceFirst("^0+(?!$)","");
        O=OtoD(O);
        String[] part=O.split("[.]");
        String H="",str_h,h_deC="";
        double deC,intG=Integer.parseInt(part[0]);
        long rm;

        //---------------Convertion of Integar part---------------
        while (intG>0){
            rm=(long) intG%16;
            intG=(long)(intG/16);
            if(rm==10){
                H= "A" + H;
            } else if (rm==11) {
                H= "B" + H;
            } else if (rm==12) {
                H= "C" + H;
            } else if (rm==13) {
                H= "D" + H;
            } else if (rm==14) {
                H= "E" + H;
            } else if (rm==15) {
                H= "F" + H;
            }
            else {
                H=String.valueOf(rm)+H;
            }

        }

        //---------------Convertion of decimal part---------------
        if (O.contains(".")) {
            deC = Integer.parseInt(part[1]);
            deC = deC / Math.pow(10, part[1].length());

            if (!part[1].equals("0")) {String str_tmp1;
                String[] str_tmp2;
                for (double count = 0; count < 4; count++) {
                    deC = deC * 16;
                    str_tmp1 = String.valueOf(deC);
                    str_tmp2 = str_tmp1.split("[.]");

                    if (str_tmp2[0].equals("10")) {
                        h_deC += "A";
                    } else if (str_tmp2[0].equals("11")) {
                        h_deC += "B";
                    } else if (str_tmp2[0].equals("12")) {
                        h_deC += "C";
                    } else if (str_tmp2[0].equals("13")) {
                        h_deC += "D";
                    } else if (str_tmp2[0].equals("14")) {
                        h_deC += "E";
                    } else if (str_tmp2[0].equals("15")) {
                        h_deC += "F";
                    } else {
                        h_deC += str_tmp2[0];
                    }
                    deC = Double.parseDouble(str_tmp2[1])/ Math.pow(10,str_tmp2[1].length());


                }
                H = H + "." + h_deC;
                return H;
            }
        }else {
            return H;
        }
        return "";
    }

}

//class maiiiin{
//    public static void main(String[] args) {
//        OtoX obj1=new OtoX();
//        String te=obj1.OtoH("15555.755");
//        System.out.println(te);
//    }
//}