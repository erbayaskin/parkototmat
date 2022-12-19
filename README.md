# parkototmat

------get ticket / reservation place for vehicle in garage (it has 10 slot)-------
Methot : POST
URL : http://localhost:8080/getTicket
Body : {
    "vehicleName":"Track Toyota Corolla 1",
    "vehicleTypeId":2  // 0:car,1:jeep,2:track
}
Example Response: {
    "data": {
        "uuid": "ebeebb59-75f7-4995-9f27-c6f95a6ffce1",
        "vehicleName": "Track Toyota Corolla 1",
        "vehicleType": 2,
        "slotStartNumber": 1,
        "reserveSlotNumbers": "1-2-3-4",
        "dateOfEntrance": "2022-12-19T22:27:32.956+00:00"
    },
    "message": "Allocated 1-2-3-4 slots."
}

-------------------------------------------------------------------------

-----Leave vehicle with ticket number -----------
Methot: POST
URL:http://localhost:8080/leave/ebeebb59-75f7-4995-9f27-c6f95a6ffce1
Body:
Example Response : {
    "data": null,
    "message": "ebeebb59-75f7-4995-9f27-c6f95a6ffce1 ticket number with vehicle is leave at 1-2-3-4 place number/numbers"
}

--------------------------------------------------------------------------

-----All slots Status check--------------
Methot: GET 
URL:http://localhost:8080/status
Body:
Example Response : {
    "data": {
        "0": {
            "uuid": "4e66df3e-d1cc-4f07-a3a5-7384ae3b6190",
            "vehicleName": "Car Toyota Corolla 1",
            "vehicleType": 0,
            "slotStartNumber": 0,
            "reserveSlotNumbers": "0",
            "dateOfEntrance": "2022-12-19T22:27:21.833+00:00"
        },
        "1": {
            "uuid": "ebeebb59-75f7-4995-9f27-c6f95a6ffce1",
            "vehicleName": "Track Toyota Corolla 1",
            "vehicleType": 2,
            "slotStartNumber": 1,
            "reserveSlotNumbers": "1-2-3-4",
            "dateOfEntrance": "2022-12-19T22:27:32.956+00:00"
        },
        "2": {
            "uuid": "ebeebb59-75f7-4995-9f27-c6f95a6ffce1",
            "vehicleName": "Track Toyota Corolla 1",
            "vehicleType": 2,
            "slotStartNumber": 1,
            "reserveSlotNumbers": "1-2-3-4",
            "dateOfEntrance": "2022-12-19T22:27:32.956+00:00"
        },
        "3": {
            "uuid": "ebeebb59-75f7-4995-9f27-c6f95a6ffce1",
            "vehicleName": "Track Toyota Corolla 1",
            "vehicleType": 2,
            "slotStartNumber": 1,
            "reserveSlotNumbers": "1-2-3-4",
            "dateOfEntrance": "2022-12-19T22:27:32.956+00:00"
        },
        "4": {
            "uuid": "ebeebb59-75f7-4995-9f27-c6f95a6ffce1",
            "vehicleName": "Track Toyota Corolla 1",
            "vehicleType": 2,
            "slotStartNumber": 1,
            "reserveSlotNumbers": "1-2-3-4",
            "dateOfEntrance": "2022-12-19T22:27:32.956+00:00"
        },
        "5": null,
        "6": null,
        "7": null,
        "8": null,
        "9": null
    },
    "message": "Status"
}

