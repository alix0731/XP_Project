package kino.xp.project.Repository;

import kino.xp.project.Model.Schedule;
import kino.xp.project.Model.Worker;
import kino.xp.project.repositories.ScheduleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * @Author Jonas, Jonathan
 * @Parameter Test af metoder relateret til schedule
 * @Output det er en test så ikke rigtig noget
 **/

public class ScheduleRepositoryTest
{

    ScheduleRepository sr = new ScheduleRepository();
    Worker testWorker = new Worker("Test");

    @Test
    public void testReadWorker()
    {
        Map<Integer, String> workerMap = sr.readAllWorkers();
        Assertions.assertFalse(workerMap.isEmpty());
    }

    @Test
    public void testReadSchedule()
    {
        List<Schedule> scheduleList = sr.readScheduleByWeek(1);
        Assertions.assertFalse(scheduleList.isEmpty());
        Assertions.assertTrue(scheduleList.get(2).getWeekNr() == 1);
    }

    @Test
    public void createAndDelWorker()
    {
        Assertions.assertTrue(sr.create(testWorker) != -1);
        Assertions.assertTrue(sr.delete(testWorker.getId()));

    }
}
