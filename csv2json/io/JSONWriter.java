/** 
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License. To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 * @author Thimo Thoeye 
 */ 
package csv2json.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import org.json.simple.JSONValue;

public class JSONWriter {
    
    public JSONWriter() {
        
    }
    
    public void write(Map<String, Object> document, File file)
        throws IOException {
        
        StringWriter out = new StringWriter();
        
        PrettyJSONWriter pretty = new PrettyJSONWriter();
        JSONValue.writeJSONString(document, pretty);
        
        String jsonText = pretty.toString();
        FileWriter outputfile = new FileWriter(file);
        outputfile.write(jsonText);
        outputfile.flush();
    }
}
