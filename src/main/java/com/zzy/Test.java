package com.zzy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.stream.Collectors;

import static com.alibaba.fastjson.parser.Feature.AutoCloseSource;

/**
 * @author 曾昭阳 zhaoyang.zeng
 * @date 2021/3/15 9:23
 */
public class Test {
    public static void main(String[] args) throws IOException, ParseException {


//        Timestamp timestamp = new Timestamp(new Date().getTime());
//        ZonedDateTime dateTime = ZonedDateTime.ofInstant(timestamp.getDate().toInstant(), ZoneId.of("UTC+8"));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss(z)");
//        dateTime.format(formatter);
//        System.out.println(dateTime.format(formatter));
//
//        Integer integer = 8;
//        Integer negetive = -8;
//        System.out.println(integer.toString());
//        System.out.println(negetive.toString());

        String eqNo = "Instrucciones para rellenar:\nTanto el número de serie de la máquina como la ID de la caja IoT se utilizarán como criterios para comprobar los elementos duplicados. Cualquier dato duplicado será omitido.\nSe requiere la ID de la caja de IoT. Si no se rellena, los datos se omiten.\nLos países y provincias se marcan como otros si no existen.\nSi la información adicional requerida está vacía, no afecta al registro de la información básica. Cuando se rellena la información adicional, si no se cumplen otros criterios de verificación, los datos siguen siendo omitidos.\nEl formato de la fecha es \"año-mes-día o año/mes/día\", por ejemplo 2021-11-25 o 2021/11/25.\nCuando rellene el cuadro de selección múltiple, separe las opciones con \",\".\nSe admiten archivos xlsx; la tabla puede contener hasta 1000 registros; el tamaño del archivo no puede superar los 5MB.";
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                for (int k = 0; k < 10; k++) {
//                    System.out.println(eqNo + i + j + k);
//                }
//            }
//        }
//        System.out.println(", option1-vn,option2-zh".split(",")[1]);
//
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//
//        Request request = new Request.Builder()
//                .url("http://operation-oss-pre.rootcloudapp.com/oss/download-expired?token=49b89005ee9e06ec087f68a00f1829ec")
//                .get()
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//        if (response.isSuccessful()) {
//            final ResponseBody body = response.body();
//            if (body != null) {
//                System.out.println(JSON.toJSONString(response.headers()));
//                System.out.println(JSON.toJSONString(body));
//                final InputStream inputStream = body.byteStream();
//                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//                byte[] bytes = new byte[1024];
//                int len;
//                File file = new File("hy3.3.1.1.tar.gz");
//                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
//                while ((len = bufferedInputStream.read(bytes)) != -1) {
//                    outputStream.write(bytes, 0, len);
//                }
//                outputStream.flush();
//                outputStream.close();
//                bufferedInputStream.close();
//                inputStream.close();
//            }
//        }
//
//        final MD5 md5 = MD5.create();
//        System.out.println(md5.digestHex(new File("C:\\Users\\zhaoyang.zeng\\Downloads\\hy3.3.1.1.tar.gz")));

        inner inner = new inner();
        inner.test();
    }
    static class inner {


        private void test() {
            try {
                JSONObject response = JSON.parseObject(this.getClass().getResourceAsStream("/response.json"), JSONObject.class, AutoCloseSource);
                JSONObject response_old = JSON.parseObject(this.getClass().getResourceAsStream("/response_old.json"), JSONObject.class, AutoCloseSource);
                final HashSet<Object> data = new HashSet<>(response_old.getJSONArray("data"));
                response_old.getJSONArray("data").removeAll(response.getJSONArray("data"));
                System.out.println(JSON.toJSONString(response_old.getJSONArray("data")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
