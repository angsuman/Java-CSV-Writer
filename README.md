# Java-CSV-Writer

An opinionated CSV Writer

# Overview

A micro-library which converts Java `List<List<String>>` to CSV.

# How to use

This example shows how Employee data (as Collection of Employee Objects) is converted to CSV format.

    import com.taragana.csv.CSVWriter;
    
    ...

    List<List<String>> data = new ArrayList<>(); // CSV data holder
    List<String> employee = new ArrayList<>();
    
    // CSV headers added
    employee.add("ID");
    employee.add("Name");
    employee.add("Mobile");
    employee.add("Email");
    employee.add("Gender");

    result.add(employee); // Adding header
    
    for(Employee e : employeeData) { // Individual Employee data added 
        employee = new ArrayList<>();        
        employee.add("" + e.id);
        employee.add(e.name);
        employee.add(e.mobile);
        employee.add(e.email);
        employee.add(e.gender);
            
        result.add(employee);
    }
    String csv = CSVWriter.encode(data)); // This method `encode` is all you need to know!

A simple example is in [CSVWriterTest](src/test/groovy/com/taragana/csv/CSVWriterTest.groovy) (written in Groovy).

    List<String[]> lines = Arrays.asList(["India"], ["is"], ["great!"]);
    assert CSVWriter.encode(lines).equals("\"" + lines.get(0)[0] + "\"\n\"" + lines.get(1)[0] + "\"\n\"" + lines.get(2)[0] + "\"");

You can also encode individual lines with `encodeLine` and cell / field with `encodeField`

# Library Code Reports

Generate the reports with:
`./gradlew check`

* [Test Report](build/reports/tests/test/index.html)
* SpotBugs Report
    * [Main](build/reports/spotbugs/main.html)
    * [Test](build/reports/spotbugs/test.html)

# Benefits

* Very small
* Single-purpose library without any bloat.
* Zero external dependencies
* Well tested (comes with unit tests)

Java-CSV-Writer is developed by Angsuman Chakraborty at [Taragana Inc](http://taragana.com).
