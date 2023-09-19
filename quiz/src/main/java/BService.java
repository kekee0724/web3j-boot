import java.util.ArrayList;
import java.util.List;

/**
 * 题目：编写一个Java函数，实现批量获取数据的功能（BService.get(List<Integer> ids)）。具体要求如下：
 * 1)提供一个函数BService.get(List<Integer> ids)，支持最多传入100个id；
 * 2)在BService.get((List<Integer> ids)函数内部，需要将传入的id列表分批（每批10个id）进行调用AService.get(List<Integer> ids)函数获取数据；
 * 3)BService.get((List<Integer> ids)函数需要返回所有批次获取的数据的合并结果，即一个包含所有数据的List<Integer>；
 */
public class BService {
    private final AService aService;

    public BService(AService aService) {
        this.aService = aService;
    }

    public List<Integer> get(List<Integer> ids) {
        List<Integer> result = new ArrayList<>();

        // 每批10个id进行调用AService.get(List<Integer> ids)
        for (int i = 0; i < ids.size(); i += 10) {
            int endIndex = Math.min(i + 10, ids.size());
            List<Integer> batchIds = ids.subList(i, endIndex);
            List<Integer> batchResult = aService.get(batchIds);
            result.addAll(batchResult);
        }

        return result;
    }
}


