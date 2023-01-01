public class BtoX {

    String setOlen(String x){

        while (x.length()%3!=0){
            x="0"+x;
        }
        return x;
    }
    String setHlen(String x){

        while (x.length()%4!=0){
            x="0"+x;
        }
        return x;
    }
    String setB(String in){
        switch (in.length()){
            case 1:in=in+"00";
                return in;
            case 2:in=in+"0";
                return in;
            case 3:return in;
        }
        return in;
    }
    String setBh(String in){
        switch (in.length()){
            case 1:in=in+"000";
                return in;
            case 2:in=in+"00";
                return in;
            case 3:return in=in+"0";
            case 4:return in;
        }
        return in;
    }

    String BtoD(String B){
        B=B.replaceFirst("^0+(?!$)","");
        String[] part=B.split("[.]");
        String str_d="",d_deC;
        double D=0,D_deC=0;
        double i=0;
        long rm=0;
        double deC,intG=Integer.parseInt(part[0]);
        if(B.contains(".")){
            deC=Integer.parseInt(part[1]);
            d_deC=part[1];
        }
        else {
            deC=0;
            d_deC="";
        }

        //---------------Convertion of Integar part---------------

        while (intG>0){
            rm=(long) intG%10;
            intG=intG/10;
            D+= rm*Math.pow(2,i);
            i++;
        }

        //---------------Convertion of decimal part---------------
        if(B.contains(".")){
            i=0;
            while (deC>0){
                rm=(long) (deC%10);
                deC=(long)(deC/10);
                D_deC+=rm*Math.pow(2,-d_deC.length()+i);
                i++;
            }
            D+=D_deC;
            if(D%1==0){
                return String.valueOf((long) D);
            }else {
                return String.valueOf(D);
            }

        }
        else {
            if(D%1==0){
                return String.valueOf((long) D);
            }else {
                return String.valueOf(D);
            }
        }
    }


    String BtoO(String B){

        B=B.replaceFirst("^0+(?!$)","");
        String[] part=B.split("[.]");
        part[0]=setOlen(part[0]);
        String str_o="",o_deC="";
        String O="";

        //---------------Convertion of Integar part---------------
        String[] temp_str= part[0].split("(?<=\\G.{" + 3 + "})");
        String[] a=new String[temp_str.length];
        for (int i= temp_str.length-1;i>=0;i--){
            a[i]=temp_str[temp_str.length-i-1];
        }
        temp_str=a;

        for(int qwe=0;qwe<temp_str.length;qwe++){
            BtoX objforBtoO =new BtoX();
           // System.out.println("temp_str[qwe]"+temp_str[qwe]);
            str_o=objforBtoO.BtoD(temp_str[qwe])+str_o;
           // System.out.println("str_o="+str_o);

        }

        //---------------Convertion of decimal part---------------
        if(B.contains(".")){
            temp_str= part[1].split("(?<=\\G.{" + 3 + "})");
            part[1]=setOlen(part[1]);
            a=new String[temp_str.length];
            for (int i= temp_str.length-1;i>=0;i--){
                a[i]=temp_str[temp_str.length-i-1];
            }
            temp_str=a;

            for (int qwe=0;qwe<temp_str.length;qwe++){
                temp_str[qwe]=setB(temp_str[qwe]);
                BtoX objforBtoO =new BtoX();
                o_deC=objforBtoO.BtoD(temp_str[qwe])+o_deC;

            }
            str_o=str_o+"."+o_deC;
            return O=str_o;
        }
        else {
            return O=str_o;
        }

    }

    String BtoH(String B){
        B=B.replaceFirst("^0+(?!$)","");
      //  System.out.println("B="+B);
       // System.out.println("setB="+B);
        String[] part=B.split("[.]");
        part[0]=setHlen(part[0]);
        String H_deC="";
        String H="";
      //  System.out.println("part[0]="+part[0]);
        //---------------Convertion of Integar part---------------
        String[] temp_str= part[0].split("(?<=\\G.{" + 4 + "})");

        String[] a=new String[temp_str.length];
        for (int i= temp_str.length-1;i>=0;i--){
            a[i]=temp_str[temp_str.length-i-1];
        }
        temp_str=a;


        for (int qwe=0;qwe<temp_str.length;qwe++){
            BtoX objforBtoH =new BtoX();
          //  System.out.println("tep_str="+temp_str[qwe]);
            String temp=objforBtoH.BtoD(temp_str[qwe]);
            if(temp.equals("10")){
                H= "A" + H;
            } else if (temp.equals("11")) {
                H= "B" + H;
            } else if (temp.equals("12")) {
                H= "C" + H;
            } else if (temp.equals("13")) {
                H= "D" + H;
            } else if (temp.equals("14")) {
                H= "E" + H;
            } else if (temp.equals("15")) {
                H= "F" + H;
            }
            else {
                H=temp+H;
            }
        }


        //---------------Convertion of decimal part---------------
        if(B.contains(".")){
            part[1]=setBh(part[1]);
          //  System.out.println("part[1]="+part[1]);
            temp_str= part[1].split("(?<=\\G.{" + 4 + "})");

            a=new String[temp_str.length];
            for (int i= temp_str.length-1;i>=0;i--){
                a[i]=temp_str[temp_str.length-i-1];
            }
            temp_str=a;

            for (int qwe=0;qwe<temp_str.length;qwe++){

                BtoX objforBtoH =new BtoX();
                String BtoH_f_str=objforBtoH.BtoD(temp_str[qwe]);
                if (BtoH_f_str.equals("10")) {
                    H_deC += "A";
                } else if (BtoH_f_str.equals("11")) {
                    H_deC += "B";
                } else if (BtoH_f_str.equals("12")) {
                    H_deC += "C";
                } else if (BtoH_f_str.equals("13")) {
                    H_deC += "D";
                } else if (BtoH_f_str.equals("14")) {
                    H_deC += "E";
                } else if (BtoH_f_str.equals("15")) {
                    H_deC += "F";
                } else {
                    H_deC += BtoH_f_str;
                }

            }
            return H+"."+H_deC;
        }
        else {

            return H;
        }

    }

}
