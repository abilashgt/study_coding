package com.abilashthomas.hive;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Abilash George Thomas on 12/29/2016.
 *
 * Reference:
 * https://acadgild.com/blog/hive-udtf/
 * http://beekeeperdata.com/posts/hadoop/2015/07/26/Hive-UDTF-Tutorial.html
 */
public class PhoneGeneratingUdtf extends GenericUDTF {
    private PrimitiveObjectInspector stringOI = null;

    @Override
    public StructObjectInspector initialize(ObjectInspector[] args) throws UDFArgumentException {

        if (args.length != 1) {
            throw new UDFArgumentException("PhoneParser: takes exactly one argument");
        }

        if (args[0].getCategory() != ObjectInspector.Category.PRIMITIVE
                    && ((PrimitiveObjectInspector) args[0]).getPrimitiveCategory() != PrimitiveObjectInspector.PrimitiveCategory.STRING) {
            throw new UDFArgumentException("PhoneParser: takes a string as a parameter");
        }

        // input inspectors
        stringOI = (PrimitiveObjectInspector) args[0];

        // output inspectors -- an object with two fields!
        List<String> fieldNames = new ArrayList<String>(2);
        List<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>(2);
        fieldNames.add("id");
        fieldNames.add("phone");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
    }

    public ArrayList<Object[]> processInputRecord(String id){
        ArrayList<Object[]> result = new ArrayList<Object[]>();

        System.out.println("====id==="+id);

        // ignoring null or empty input
        if (id == null || id.isEmpty()) {
            return result;
        }

        //String[] tokens = id.split("\\s+");
        String[] tokens = id.split(",");

        if (tokens.length == 2){
            result.add(new Object[] { tokens[0], tokens[1]});
        }

        else if (tokens.length == 3){
            result.add(new Object[] { tokens[0], tokens[1]});
            result.add(new Object[] { tokens[0], tokens[2]});
        }

        return result;
    }

    @Override
    public void process(Object[] record) throws HiveException {
        final String id = stringOI.getPrimitiveJavaObject(record[0]).toString();
        ArrayList<Object[]> results = processInputRecord(id);
        Iterator<Object[]> it = results.iterator();
        while (it.hasNext()){
            Object[] r = it.next();
            forward(r);
        }
    }

    @Override
    public void close() throws HiveException {

    }
}
