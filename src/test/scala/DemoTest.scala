import com.holdenkarau.spark.testing.SharedSparkContext
import demo.Demo
import org.scalatest.FunSuite

class DemoTest extends FunSuite with SharedSparkContext{
  test("get rdd12") {
    val result = Demo.get("D:\\taskSparkAdvance\\Demo\\test2.csv", sc)
    assert(result.toList.length == 3)
  }
}
