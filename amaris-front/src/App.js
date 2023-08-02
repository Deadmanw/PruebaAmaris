import React, { useState } from 'react';

function App() {
  const [employeeData, setEmployeeData] = useState(null);
  const [employeeList, setEmployeeList] = useState(null);
  const [id, setId] = useState('');

  const urlEmployee='http://localhost:8080/api/employee/getEmployee';
  const urlList='http://localhost:8080/api/employee/getEmployeeList';


  const fetchEmployee = async () => {
    try {
      if (id.trim() !== '') {
        const response = await fetch(urlEmployee, {
          method: 'POST', 
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ id: id }) 
        });
        const data = await response.json();
        if (data.ok===true) {
          const errorMessage = 'Demasiadas peticiones. Intenta más tarde.';
          window.alert(errorMessage);
          console.log('Employee Response:', data);
          return;
        }
        setEmployeeData(data.data);
        console.log('Employee Response:', data); 
      } else {
        const response = await fetch(urlList);

        const data = await response.json();

        if (data.ok===true) {
          const errorMessage = 'Demasiadas peticiones. Intenta más tarde.';
          window.alert(errorMessage);
          console.log('Employee List Response:', data);
          return;
        }
        setEmployeeList(data.data);

        console.log('Employee List Response:', data);
      }
    } catch (error) {
      window.alert(error);
      console.error('Error fetching employee:', error);
      if (error instanceof TypeError && error.message === 'Failed to fetch') {
        const errorMessage = 'Demasiadas peticiones. Intenta más tarde.';
        window.alert(errorMessage);
        console.error(errorMessage);
      }
    }
  };
  

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-md-6">
          <label htmlFor="id" className="form-label">Enter ID:</label>
          <div className="input-group">
            <input
              type="text"
              id="id"
              className="form-control"
              placeholder="Enter ID"
              value={id}
              onChange={(e) => setId(e.target.value)}
            />
            <button className="btn btn-primary" onClick={fetchEmployee}>Buscar</button>
          </div>
        </div>
      </div>

      {employeeData && (
        <div>
          <h2>Detalles del empleado</h2>
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Age</th>
                <th>Annual Salary</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{employeeData.id}</td>
                <td>{employeeData.employee_name}</td>
                <td>{employeeData.employee_salary}</td>
                <td>{employeeData.employee_age}</td>
                <td>{employeeData.employee_annual_salary}</td>
              </tr>
            </tbody>
          </table>
        </div>
      )}

      {employeeList && (
        <div>
          <h2>Lista de empleados</h2>
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Age</th>
                <th>Annual Salary</th>
              </tr>
            </thead>
            <tbody>
              {employeeList.map((employee) => (
                <tr key={employee.id}>
                  <td>{employee.id}</td>
                  <td>{employee.employee_name}</td>
                  <td>{employee.employee_salary}</td>
                  <td>{employee.employee_age}</td>
                  <td>{employee.employee_annual_salary}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default App;
