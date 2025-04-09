package com.kodilla.testing.shapes;

import org.junit.jupiter.api.*;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of test");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Shape collector tests")
    class ShapeCollectorTests {

        @Test
        void addFigure() {
            //given
            ShapeCollector shapeCollector = new ShapeCollector();

            //when
            shapeCollector.addFigure(new Square(12));

            //then
            Assertions.assertEquals(1, shapeCollector.getShapeCount());

        }

        @Test
        void removeFigure() {
            //given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Square(12));
            //when
            shapeCollector.removeFigure(new Square(12));
            //then
            Assertions.assertEquals(0, shapeCollector.getShapeCount());
        }

        @Test
        void getFigure() {
            //given
            Square square = new Square(12);
            Circle circle = new Circle(12);
            Triangle triangle = new Triangle(3, 4, 5, 3);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);
            //when
            Shape theFigure = shapeCollector.getFigure(1);
            //then
            System.out.println(theFigure);
            System.out.println(theFigure.toString());
            Assertions.assertEquals(circle, theFigure);

        }

        @Test
        void showFigures() {
            //given
            Square square = new Square(12);
            Circle circle = new Circle(12);
            Triangle triangle = new Triangle(3, 4, 5, 3);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);
            //when
            String allFigures = shapeCollector.showFigures();
            //then
            Assertions.assertEquals("Square, Circle, Triangle", allFigures);

        }
    }

}
