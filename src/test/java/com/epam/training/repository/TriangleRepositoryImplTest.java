package com.epam.training.repository;

import com.epam.training.entity.Id;
import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import com.epam.training.repository.impl.TriangleRepository;
import com.epam.training.repository.impl.comparator.TriangleComparatorByArea;
import com.epam.training.repository.impl.specification.TrianglesByAreaBetweenSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

public class TriangleRepositoryImplTest {
    private final Id id1 = new Id(0L);
    private final Id id2 = new Id(1L);
    private final Id id3 = new Id(2L);
    private final Id id4 = new Id(3L);
    private final Id id5 = new Id(4L);

    private final Point pointA = new Point(0, 0);
    private final Point pointB = new Point(3, 0);
    private final Point pointC = new Point(0, 4);
    private final Point pointD = new Point(6, 0);
    private final Point pointE = new Point(0, 8);

    private final Triangle ABC = new Triangle(pointA, pointB, pointC);
    private final Triangle ABE = new Triangle(pointA, pointB, pointE);
    private final Triangle ACD = new Triangle(pointA, pointC, pointD);
    private final Triangle ADE = new Triangle(pointA, pointD, pointE);
    private final Triangle BDE = new Triangle(pointB, pointD, pointE);

    {
        ABC.setId(id1);
        ABE.setId(id2);
        ACD.setId(id3);
        ADE.setId(id4);
        BDE.setId(id5);
    }

    private final Repository<Triangle> repository = TriangleRepository.getInstance();

    {
        repository.add(ABE);
        repository.add(ACD);
        repository.add(ADE);
        repository.add(ABC);
    }

    @Test
    public void testAddTriangle() {
        //given
        int sizeBefore = repository.getAll().size();
        //when
        repository.add(BDE);
        int resultSize = repository.getAll().size();
        //then
        Assert.assertEquals(sizeBefore + 1, resultSize);
    }

    @Test
    public void testRemoveTriangle_Four_Three_True() {
        //given
        int sizeBefore = repository.getAll().size();
        //when
        repository.remove(ABC);
        int resultSize = repository.getAll().size();
        //then
        Assert.assertEquals(sizeBefore - 1, resultSize);
    }

    @Test
    public void testUpdateTriangle_ABD_BDE_Zero_to_Four_True() {
        //given
        Triangle replacedTriangle = BDE;
        replacedTriangle.setId(id1);
        int replacedID = 0;
        //when
        repository.update(BDE);
        Triangle resultTriangle = repository.getAll().get(replacedID);
        //then
        Assert.assertEquals(replacedTriangle, resultTriangle);
    }

    @Test
    public void testSort_ABC_LowestAreaTriangle_True() {
        //given
        Comparator<Triangle> comparator = new TriangleComparatorByArea();
        Triangle lowestAreaTriangle = ABC;
        int lowestIndexAreaTriangle = 0;
        //when
        repository.sort(comparator);
        Triangle resultTriangle = repository.getAll().get(lowestIndexAreaTriangle);
        //then
        Assert.assertEquals(lowestAreaTriangle, resultTriangle);
    }

    @Test
    public void testQuery_One_Triangle_In_Range_True() {
        //given
        double area1 = 3.0;
        double area2 = 10.0;
        Specification<Triangle> specification = new TrianglesByAreaBetweenSpecification(area1, area2);
        int triangleNumbersInAreaRange = 1;
        //when
        int resultTriangleNumbersInAreaRange = repository.query(specification).size();
        //then
        Assert.assertEquals(triangleNumbersInAreaRange, resultTriangleNumbersInAreaRange);
    }
}