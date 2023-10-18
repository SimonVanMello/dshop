import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';

type AddedProductAlertProps = {
    showAddedProductAlert: boolean,
    setShowAddedProductAlert: (newState: boolean) => void
};

const AddedProductAlert = (props: AddedProductAlertProps) : JSX.Element => {
    return (
        <Alert show={props.showAddedProductAlert} variant="success">
            <Alert.Heading>Success</Alert.Heading>
            <p>
                The product was successfully added to the database.
            </p>
            <hr />
            <div className="d-flex justify-content-end">
                <Button onClick={() => props.setShowAddedProductAlert(false)} variant="outline-success">
                    Close
                </Button>
            </div>
        </Alert>
    )
};

export default AddedProductAlert;