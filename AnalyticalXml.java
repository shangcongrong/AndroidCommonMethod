import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AnalyticalXml {

	public static void main(String[] args) {

        List<String> privateViewName = new ArrayList<String>();
        List<String> initViewName = new ArrayList<String>();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("D://layout.xml"));
            String lineOne = br.readLine();// 一次读入一行，直到读入null为文件结束
            while (lineOne != null) {
                if (lineOne.contains("<") && !lineOne.contains("</")) {
                    String lineTwo = br.readLine();
                    if (lineTwo.contains("@+id/")) {
                        String tag = lineOne.substring(
                                lineOne.indexOf("<") + 1, lineOne.length());
                        if (!tag.equals("include")) {
                            String viewName = lineTwo.substring(
                                    lineTwo.indexOf("/") + 1, lineTwo.length() - 1);
                            privateViewName.add("private " + tag + " " + upperFirstWord(viewName) + ";");
                            initViewName.add(upperFirstWord(viewName) + " = (" + tag + ") findViewById(R.id." + viewName + ");");
                        }
                    }
                }
                lineOne = br.readLine(); // 接着读下一行
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String str : privateViewName) {
            System.out.println(str);
        }
        System.out.println();
        for (String str : initViewName) {
            System.out.println(str);
        }
    }

    public static String upperFirstWord(String viewName) {
        StringBuffer sb = new StringBuffer();
        String s = viewName;

        char[] c = s.toCharArray();
        sb.append((c[0] + "").toUpperCase());
        for (int i = 1; i < c.length; i++) {
            if (c[i] == '_') {
                sb.append((c[++i] + "").toUpperCase());
            } else {
                sb.append((c[i]));
            }
        }

        return "m" + sb.toString();
    }

}
