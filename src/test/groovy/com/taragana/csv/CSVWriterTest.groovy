package com.taragana.csv

import spock.lang.Specification

class CSVWriterTest extends Specification {
    def "EncodeField"() {
        when:
        def field = "Donald Knuth said, \"Premature optimization is the root of all evil\""

        then:
        CSVWriter.encodeField(field).equals("\"Donald Knuth said, \"\"Premature optimization is the root of all evil\"\"\"")
    }

    def "EncodeLine"() {
        when:
        def field1 = "Donald Knuth said, \"Premature optimization is the root of all evil\""
        def field2 = "\"Talk is cheap. Show me the code.\" -- Linus Torvalds"
        def field3 = "\"Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live\" -- John Woods"

        then:
        CSVWriter.encodeLine(field1, field2, field3).equals("\"Donald Knuth said, \"\"Premature optimization is the root of all evil\"\"\",\"\"\"Talk is cheap. Show me the code.\"\" -- Linus Torvalds\",\"\"\"Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live\"\" -- John Woods\"")
    }

    def "Encode"() {
        when:
        List<String[]> lines = Arrays.asList(["India"], ["is"], ["great!"])

        then:
        CSVWriter.encode(lines).equals("\"" + lines.get(0)[0] + "\"\n\"" + lines.get(1)[0] + "\"\n\"" + lines.get(2)[0] + "\"")
    }
}
