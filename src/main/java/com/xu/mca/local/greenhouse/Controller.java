package com.xu.mca.local.greenhouse;



/**
 * java_study
 */
public class Controller {
    EventSet es = new EventSet();
    public void addEvent(Event event) {
        es.add(event);
    }
    public void run() {
        Event e;
        while ((e = es.getNext()) != null) {
            if (e.ready()) {
                e.action();
                System.out.println(e.description());
                es.removeCurrent();
            }
        }
    }
}
class EventSet{
    private Event[] events = new Event[100];
    private int index = 0;
    private int next = 0;
    public void add(Event event) {
        if (index >= events.length) {
            return;
        }
        events[index++] = event;
    }

    public Event getNext() {
        boolean looped = false;
        int start = next;
        do {
            next = (next + 1) % events.length;
            if (start == next) {
                looped = true;
            }

            if ((next == (start + 1) % events.length) && looped) {
                return null;
            }

        } while (events[next] == null);
        return events[next];
    }

    public void removeCurrent() {
        events[next] = null;
    }
}