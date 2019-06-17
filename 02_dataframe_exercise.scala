// DATAFRAME PROJECT
// Use the Netflix_2011_2016.csv file to Answer and complete
// the commented tasks below!

// Start a simple Spark Session

// Load the Netflix Stock CSV File, have Spark infer the data types.

// Start a simple Spark Session
import org.apache.spark.sql.SparkSession
import spark.implicits._
val spark = SparkSession.builder().getOrCreate()

// Create a DataFrame from Spark Session read csv
// Technically known as class Dataset
val df = spark.read.option("header","true").option("inferSchema","true").csv("Netflix_2011_2016.csv")

// Show Schema
df.printSchema()

// What are the column names?
df.columns

// Print out the first 5 columns.
for(line <- df.head(5))
    println(line)

// Use describe() to learn about the DataFrame.
df.describe()

// Create a new dataframe with a column called HV Ratio that
// is the ratio of the High Price versus volume of stock traded
// for a day.
df.withColumn("HV_Ratio", $"High" / $"Volume").show()

// What day had the Peak High in Price?
df.orderBy($"High".desc).show()

// What is the mean of the Close column?
df.select(mean($"Close")).show()

// What is the max and min of the Volume column?
df.select(max($"Volume")).show()
df.select(min($"Volume")).show()

// How many days was the Close lower than $ 600?
df.filter($"Close" < 600).count()

// What percentage of the time was the High greater than $500 ?
df.filter($"High" > 500).count() * 1.0 / df.count()

// What is the max High per year?
df.withColumn("Year", year($"Date")).groupBy($"Year").max().select($"Year", $"max(High)").show()

// What is the average Close for each Calender Month?
df.withColumn("Month", month($"Date")).groupBy($"Month").avg().select($"Month", $"avg(Close)").orderBy($"Month").show()