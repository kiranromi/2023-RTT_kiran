
    let techMap = [
        {"id": 1, "value": "JAVA/J2EE"},
        {"id": 2, "value": "Microsoft Technoligies"},
        {"id": 3, "value": "FullStack Developer"},
        {"id": 4, "value": "Database Developer"},
        {"id": 5, "value": "Database Administrator"},
        {"id": 6, "value": "FrontEnd"},
        {"id": 7, "value": "DevOps"},
        {"id": 8, "value": "Cloud Technologies"},
        {"id": 9, "value": "GO"},
        {"id": 10, "value": "Scrum Master"},
        {"id": 11, "value": "PYTHON"},
    ]

        var technologyDropdown = document.getElementById('technologyDropdown');
        var interviewerDropdown = document.getElementById('interviewerDropdown');
        var submitBtn = document.getElementById('submitBtn');

        populateDropdown(technologyDropdown, techMap);

        // Populate any dropdown with given items
        function populateDropdown(dropdown, items) {
            dropdown.innerHTML = '<option value="0">Select an option</option>'; // Clear existing options
            items.forEach(item => {
                let option = new Option(item.value, item.id);
                dropdown.options.add(option);
            });
        }
        
       function populateIntDropdown(dropdown, items) {
            dropdown.innerHTML = '<option value="0">Select an option</option>'; // Clear existing options
            items.forEach(item => {
				console.log(item);
                let option = new Option(`${item.firstName+' '+item.lastName}`, item.id);
                console.log('options..', option);

                dropdown.options.add(option);
            });
        }

        // Handle changes in the technology dropdown
        technologyDropdown.addEventListener('change', function() {
            var selectedTechnology = this.value;
            if(selectedTechnology === "0") {
                populateDropdown(interviewerDropdown, []);
                return;
            };

    	fetch('http://localhost:8080/users/technology/'+selectedTechnology)
    	 // Update with the URL of your data source
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(fetchedData => {
			console.log(fetchedData);
             populateIntDropdown(interviewerDropdown, fetchedData);
        })
        .catch(error => console.error('Error fetching data:', error));
        
        });

        submitBtn.addEventListener('click', function() {
            var selectedTechnology = technologyDropdown.value;
            var selectedInterviewer = interviewerDropdown.value;

            // Ensure that both selections are made
            if (!selectedTechnology || !selectedInterviewer) {
                alert("Please select both technology and interviewer.");
                return; // Exit the function if selections are not made
            }

            // Prepare data to send with the POST request
            var dataToSend = {
                technologyId: selectedTechnology,
                interviewerId: selectedInterviewer                
            };

            fetch('http://localhost:8080/interviews/'+selectedTechnology+'/assign/'+selectedInterviewer, {
                method: 'PUT',
                body: JSON.stringify(dataToSend),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.json())
            .then(data => {
                // Handle response data from the server
                console.log('Success:', data);
            })
            .catch(error => console.error('Error:', error));
    });
