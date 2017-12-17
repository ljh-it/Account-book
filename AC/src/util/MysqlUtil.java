package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MysqlUtil {
	public static void backup(String mysqlPath, String backupFile) {
        try {
            String commandFormate = "%s/bin/mysqldump -u%s -p%s   -hlocalhost   -P%d %s -r %s";
            String command = String.format(commandFormate, mysqlPath,DBUtil.loginName,DBUtil.password,DBUtil.port,DBUtil.database,backupFile);
            Process p = Runtime.getRuntime().exec(command);
            System.out.println(command);
            try(    BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));) {
                String line = null;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
     
    public static void recover(String mysqlPath, String recoverFile) {
        try {
            String commandFormate = "%s/bin/mysql -u%s -p%s  %s";
            String command = String.format(commandFormate, mysqlPath, DBUtil.loginName, DBUtil.password,DBUtil.database);
            System.out.println(command);
            Process p = Runtime.getRuntime().exec(command);
            String line = null;
            StringBuffer sb = new StringBuffer();
            try (OutputStream out = p.getOutputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverFile),"utf8"));
                    OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
                ){
                while((line = br.readLine())!=null) {
                    sb.append(line+"\n");
                }
                String sqlCommands = sb.toString();
                System.out.println(sqlCommands);
                writer.write(sqlCommands);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {
        String mysqlPath = "/usr/local/mysql";
        String file = "/Users/lujuhong/Desktop/mysql/Bill.sql";
 
        backup(mysqlPath, file);
        // restore();
        // recover(mysqlPath, file);
        // recover(file);
       // recover(mysqlPath, file);
 
    }
}
