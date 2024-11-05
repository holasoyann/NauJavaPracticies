package ru.nikitina.NauJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nikitina.NauJava.dao.LogRepositoryCustomImpl;
import ru.nikitina.NauJava.entities.*;
import ru.nikitina.NauJava.repositories.*;
import ru.nikitina.NauJava.services.LoggingLevelService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class NauJavaApplicationTests {
	private final LoggingLevelService loggingLevelService;

	private final LogRepository logRepository;
	private final LoggingLevelRepository loggingLevelRepository;
	private final EventRepository eventRepository;
	private final EventTypeRepository eventTypeRepository;
	private final ImportanceLevelRepository importanceLevelRepository;
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

    private LogRepositoryCustomImpl logRepositoryCustomImpl;

	@Autowired
	NauJavaApplicationTests(LoggingLevelService loggingLevelService, LogRepository logRepository, LoggingLevelRepository loggingLevelRepository,
			EventRepository eventRepository, EventTypeRepository eventTypeRepository, ImportanceLevelRepository importanceLevelRepository,
			UserRepository userRepository, RoleRepository roleRepository, LogRepositoryCustomImpl logRepositoryCustomImpl)
	{
		this.loggingLevelService = loggingLevelService;
		this.logRepository = logRepository;
		this.loggingLevelRepository = loggingLevelRepository;
		this.eventRepository = eventRepository;
		this.eventTypeRepository = eventTypeRepository;
		this.importanceLevelRepository = importanceLevelRepository;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.logRepositoryCustomImpl = logRepositoryCustomImpl;
	}

	@Test
	void testFindUserByName()
	{
		var userName = UUID.randomUUID().toString();
		var role = new Role("role1");
		var user = new User(userName, "password", role);
		userRepository.save(user);

		var foundUser = userRepository.findByUsername(userName).getFirst();

		Assertions.assertNotNull(foundUser);
		Assertions.assertEquals(user.getId(), foundUser.getId());
		Assertions.assertEquals(userName, foundUser.getUsername());
	}

	@Test
	void testFindBySourceAndTimestamp()
	{
		var timestamp = new Date();
		var imLevel4 = new ImportanceLevel("name6", "decsc4", 0);
		var loggingLevel2 = new LoggingLevel("name6", "decsc2", imLevel4);
		var source = "source6";
		var message = "message6";
		var userName1 = UUID.randomUUID().toString();
		var userRole1 = new Role("role6");
		var user1 = new User(userName1, "password6", userRole1);
		var log = new Log(timestamp, loggingLevel2, source, message, user1);
		logRepository.save(log);

		var foundLog = logRepository.findBySourceAndTimestamp(source, timestamp).getFirst();

		Assertions.assertNotNull(foundLog);
		Assertions.assertEquals(log.getId(), foundLog.getId());
		Assertions.assertEquals(source, foundLog.getSource());
		Assertions.assertEquals(timestamp, foundLog.getTimestamp());
	}

	@Test
	void test_5section() {
		var role = new Role("role0");
		roleRepository.save(role);

		var userName = UUID.randomUUID().toString();
		var userRole = new Role("role1");
		var user = new User(userName, "password", userRole);
		userRepository.save(user);

		var importanceLevel = new ImportanceLevel("name1", "decsc1", 0);
		importanceLevelRepository.save(importanceLevel);

		var imLevel = new ImportanceLevel("name2", "decsc2", 0);
		var loggingLevel = new LoggingLevel("name1", "decsc1", imLevel);
		loggingLevelRepository.save(loggingLevel);

		var imLevel3 = new ImportanceLevel("name3", "decsc3", 0);
		var eventType = new EventType("name2", "decsc3", imLevel3);
		eventTypeRepository.save(eventType);

		var timestamp = new Date();
		var imLevel4 = new ImportanceLevel("name4", "decsc4", 0);
		var loggingLevel2 = new LoggingLevel("name2", "decsc2", imLevel4);
		var source = "source1";
		var message = "message1";
		var userName1 = UUID.randomUUID().toString();
		var userRole1 = new Role("role1");
		var user1 = new User(userName1, "password", userRole1);
		var log = new Log(timestamp, loggingLevel2, source, message, user1);
		logRepository.save(log);

		var imLevel5 = new ImportanceLevel("name5", "decsc5", 0);
		var eventType2 = new EventType("name2", "decsc2", imLevel5);
		var context = "context";
		var userName2 = UUID.randomUUID().toString();
		var userRole2 = new Role("role1");
		var user2 = new User(userName2, "password", userRole2);
		var event = new Event(timestamp, eventType2, source, message, context, user2);
		eventRepository.save(event);
	}

	@Test
	void test_6section() {
		var timestamp = new Date();
		var imLevel4 = new ImportanceLevel("name4", "decsc4", 0);
		var loggingLevel2 = new LoggingLevel("name2", "decsc2", imLevel4);
		var source = "source1";
		var message = "message1";
		var userName1 = UUID.randomUUID().toString();
		var userRole1 = new Role("role1");
		var user1 = new User(userName1, "password", userRole1);
		var log = new Log(timestamp, loggingLevel2, source, message, user1);
		logRepository.save(log);

		var foundBySource= logRepositoryCustomImpl.findBySource(source).getFirst();
		Assertions.assertEquals(source, foundBySource.getSource());

		var foundByLoggingLevel = logRepositoryCustomImpl.findBySourceAndMessage(source, message).getFirst();
		Assertions.assertEquals(loggingLevel2.getName(), foundByLoggingLevel.getLoggingLevel().getName());
	}

	@Test
	void test_7section() {
		var imLevel4 = new ImportanceLevel("name4", "decsc4", 0);
		var loggingLevel = new LoggingLevel("name1", "decsc1", imLevel4);


		var timestamp = new Date();
		var source1 = "source1";
		var message = "message1";
		var userName1 = UUID.randomUUID().toString();
		var role = new Role("role0");
		var user1 = new User(userName1, "password", role);

		var log1 = new Log(timestamp, loggingLevel, source1, message, user1);
		logRepository.save(log1);
		loggingLevelRepository.save(loggingLevel);
		loggingLevelService.deleteLog(loggingLevel.getId());

		var foundLoggingLevel = loggingLevelRepository.findById(loggingLevel.getId());
		Assertions.assertTrue(foundLoggingLevel.isEmpty());

		var foundLog1 = logRepository.findById(log1.getId());
		Assertions.assertTrue(foundLog1.isEmpty());
	}
}
