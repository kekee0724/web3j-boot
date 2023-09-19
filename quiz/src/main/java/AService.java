import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class AService {
    // 模拟AService获取数据的函数
    public List<Integer> get(List<Integer> ids) {
        List<Integer> data = new ArrayList<>();

        // 这里只是一个简单的示例，实际情况下，您需要根据传入的ids查询数据源并返回对应的数据
        for (Integer id : ids) {
            // 模拟根据id获取数据的过程，这里只是简单返回id本身
            data.add(id);
        }

        return data;
    }
}