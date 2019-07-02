package demo

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD


object Demo {
  def main(args: Array[String]) {
    val conf =
      new SparkConf()
        .setAppName("ClusterScore")
        .setMaster("local") // <--- This is what's missing
        .set("spark.storage.memoryFraction", "1")
    val url = "D:\\taskSparkAdvance\\Demo\\test2.csv"
    val sc = new SparkContext(conf)
    val topThreeHotelsFromData = get(url, sc)
    sc.stop()
  }

  def get (url : String, sc : SparkContext) : collection.Map[(String, String), Long] = {
    val rdd = sc.textFile(url)
    val header = rdd.first()
    val data = rdd.filter(row => row != header)
    data
      .map(row => row.split(","))
      .map(row => ((row(19), row(20)), 1))
      .countByKey()
      .take(3)
  }
}
