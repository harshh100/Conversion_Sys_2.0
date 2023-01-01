public class DtoX {

    String DtoB(String D) {
        D=D.replaceFirst("^0+(?!$)","");
        String[] part = D.split("[.]");
        String str_b = "", b_deC ="";
        String B = "";
        long rm = 0;
        double deC, intG = Integer.parseInt(part[0]);
        //---------------Convertion of Integar part---------------
        while (intG > 0) {
            rm = (long) (intG % 2); //1   0   0   1   1
            intG = (long) (intG / 2);  //12  6   3   1   0
            str_b = String.valueOf(rm) + str_b;

        }

        //---------------Convertion of decimal part---------------
        if (D.contains(".")) {
            deC = Integer.parseInt(part[1]);
            deC = deC / Math.pow(10, part[1].length());

            if (!part[1].equals("0")) {
                String str_tmp1;
                String[] str_tmp2;
                for (double count = 0; count < 4; count++) {
                    deC = deC * 2;
                    str_tmp1 = String.valueOf(deC);
                    str_tmp2 = str_tmp1.split("[.]");
                    b_deC += str_tmp2[0];
                    deC = Double.parseDouble(str_tmp2[1])/ Math.pow(10,str_tmp2[1].length());
                }
                str_b = str_b + "." + b_deC;

                return B = str_b;

            }
        } else {
            return B = str_b;
        }
        return "";
    }
    String DtoO(String D){
        D=D.replaceFirst("^0+(?!$)","");
        String[] part=D.split("[.]");
        String str_o="",o_deC="";
        String O="";
        long rm=0;
        double deC,intG=Integer.parseInt(part[0]);

        //---------------Convertion of Integar part---------------

        while (intG>0){
            rm=(long) (intG%8);
            intG=(long)(intG/8);
            str_o=String.valueOf(rm)+str_o;
        }

        //---------------Convertion of decimal part---------------
        if (D.contains(".")) {
            deC = Integer.parseInt(part[1]);
            deC = deC / Math.pow(10, part[1].length());

        if(!part[1].equals("0")){
            String str_tmp1;
            String[] str_tmp2;
            for (double count = 0; count < 4; count++) {
                deC = deC * 8;
                str_tmp1 = String.valueOf(deC);
                str_tmp2 = str_tmp1.split("[.]");
                o_deC += str_tmp2[0];
                deC = Double.parseDouble(str_tmp2[1])/ Math.pow(10,str_tmp2[1].length());

            }
            str_o = str_o + "." + o_deC;

            return O = str_o;

        }
        }
        else {
            return O=str_o;
        }
return "";
    }

    String DtoH(String D){
        D=D.replaceFirst("^0+(?!$)","");
        String[] part=D.split("[.]");
        String str_h="",h_deC="";
        double deC,intG=Integer.parseInt(part[0]);
         long DtoH_rm;
         String DtoH_H="";

        //---------------Convertion of Integar part---------------

        while (intG>0){
            DtoH_rm=(long) intG%16;
            intG=(long)(intG/16);
            if(DtoH_rm==10){
                DtoH_H= "A" + DtoH_H;
            } else if (DtoH_rm==11) {
                DtoH_H= "B" + DtoH_H;
            } else if (DtoH_rm==12) {
                DtoH_H= "C" +DtoH_H;
            } else if (DtoH_rm==13) {
                DtoH_H= "D" + DtoH_H;
            } else if (DtoH_rm==14) {
                DtoH_H= "E" + DtoH_H;
            } else if (DtoH_rm==15) {
                DtoH_H= "F" + DtoH_H;
            }
            else {
                DtoH_H=String.valueOf(DtoH_rm)+DtoH_H;
            }

        }

        //---------------Convertion of decimal part---------------
        if (D.contains(".")) {
            deC = Integer.parseInt(part[1]);
            deC = deC / Math.pow(10, part[1].length());

            if (!part[1].equals("0")) {
                String str_tmp1;
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
                DtoH_H = DtoH_H + "." + h_deC;
                return DtoH_H;
            }
        }
        else {
            return DtoH_H;
        }
return "";
    }
}
